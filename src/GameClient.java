import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public GameClient(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Receive messages from the server
        new Thread(() -> {
            try {
                String fromServer;
                while ((fromServer = in.readLine()) != null) {
                    System.out.println("Server: " + fromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Send commands to the server
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter command:");
                String command = scanner.nextLine();
                out.println(command);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient("127.0.0.1", 12345);
    }
}
