import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private Scanner scanner = new Scanner(System.in);
    private Socket socket = null;
    private DataInputStream  inputStream;
    private DataOutputStream outputStream;
    private Thread thread;

    private boolean isRunning = true;

    private void openConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Wait for connection...");

        socket = serverSocket.accept();
        inputStream  = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        System.out.println("Connection established");

        thread = new Thread(() -> {
            try {
                while (true) {
                    String clientMessage = inputStream.readUTF();
                    if (clientMessage.equals(EchoConstants.STOP_WORD)) {
                        openConnection(serverSocket);
                        break;
                    }
                    System.out.println("Client message: " + clientMessage);
                }
            } catch (SocketException ex) {
                try {
                    if (isRunning) openConnection(serverSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
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

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(EchoConstants.PORT)) {
            System.out.println("Server is running.");

            openConnection(serverSocket);

            while (true) {
                String message = scanner.nextLine();
                sendMessage(message);

                if (message.equals(EchoConstants.STOP_WORD)) {
                    isRunning = false;
                    closeConnection();
                    break;
                }
            }

            System.out.println("Server shutting down");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}