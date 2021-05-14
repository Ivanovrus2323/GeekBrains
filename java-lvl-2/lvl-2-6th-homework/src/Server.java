import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(EchoConstants.PORT)) {
            System.out.println("Server is running. Wait for connection...");

            socket = serverSocket.accept();
            DataInputStream  inputStream  = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("Connection established");

            while (true) {
                String string = inputStream.readUTF();

                if (string.equals(EchoConstants.STOP_WORD)) break;

                System.out.println("Message received " + string);

                outputStream.writeUTF("Echo : " + string);
            }

            System.out.println("Server shutting down");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}