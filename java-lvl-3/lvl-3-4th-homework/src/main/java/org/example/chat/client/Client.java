package org.example.chat.client;

import org.example.chat.EchoConstants;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Client extends JFrame {
    private static final String HISTORY_PATH = "chat_history.txt";
    private static final Path path = Paths.get(HISTORY_PATH);
    private Scanner scanner = new Scanner(System.in);
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private boolean auth = false;

    private void openConnection() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Соединение установлено");

            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Введите пароль в формате login:::password");

                        String strFromServer = in.readUTF();
                        if(strFromServer.startsWith("/authok")) {
                            auth = true;
                            System.out.println("Вы успешно вошли в чат");
                            break;
                        }
                        System.out.println(strFromServer);
                    }

                    showMessages();

                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) break;

                        saveMessage(strFromServer);
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        if (!message.trim().isEmpty()) {
            try {
                if (auth == true) saveMessage("Вы: " + message);
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send error occurred");
            }
        }
    }

    public static void start() {
        Client client = new Client();
        client.openConnection();

        while (true) {
            String message = client.scanner.nextLine();
            if (client.auth) {
                client.sendMessage(message);
            } else {
                String[] messageS = message.split(":::");
                if (messageS.length != 2) {
                    System.out.println("Неверный формат");
                } else {
                    client.sendMessage("/auth " + messageS[0] + " " + messageS[1]);
                }
            }

            if (message.equals(EchoConstants.STOP_WORD)) {
                client.closeConnection();
                break;
            }
        }

        System.out.println("Client shutting down");
    }

    public static void saveMessage(String message) {
        try {
            Files.write(path, (message + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMessages() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_PATH))) {
            LinkedList<String> list = new LinkedList();

            while (reader.readLine() != null) {
                list.add(reader.readLine());
                if (list.size() > 100) list.remove(0);
            }

            for (String str : list) System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}