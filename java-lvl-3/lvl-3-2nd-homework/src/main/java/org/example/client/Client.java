package org.example.client;

import org.example.EchoConstants;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {
    private Scanner scanner = new Scanner(System.in);
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private boolean auth = false;

    private void openConnection() throws IOException {
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
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
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
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send error occurred");
            }
        }
    }

    public static void start() throws IOException {
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
}