import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {
    private Scanner scanner = new Scanner(System.in);
    private Socket socket;
    private DataInputStream  inputStream;
    private DataOutputStream outputStream;

    private void openConnection() throws IOException {
        socket = new Socket(EchoConstants.HOST, EchoConstants.PORT);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        System.out.println("Connection established");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String serverMessage = inputStream.readUTF();
                    if (serverMessage.equals(EchoConstants.STOP_WORD)) {
                        break;
                    }
                    System.out.println("Server message: " + serverMessage);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                closeConnection();
                System.exit(0);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void closeConnection() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
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
                outputStream.writeUTF(message);
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
            client.sendMessage(message);

            if (message.equals(EchoConstants.STOP_WORD)) {
                client.closeConnection();
                break;
            }
        }

        System.out.println("Client shutting down");
    }
}