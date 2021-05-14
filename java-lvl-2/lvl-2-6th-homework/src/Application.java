import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            Server server = new Server();
            server.start();
        }).start();

        Client.start();
    }
}