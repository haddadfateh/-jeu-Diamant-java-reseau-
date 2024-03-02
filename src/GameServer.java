import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private static final int PORT = 12345;
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    private static GameState gameState = new GameState();

    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(PORT)) {
            System.out.println("Le serveur Diamant est en fonctionnement...");
            while (true) {
                Socket socket = listener.accept();
                GameServerHandler handler = new GameServerHandler(socket, gameState);
                pool.execute(handler);
            }
        }
    }
}
