import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

class GameServerHandler implements Runnable {
    private Socket socket;
    private GameState gameState;
    private Player player;

    public GameServerHandler(Socket socket, GameState gameState) {
        this.socket = socket;
        this.gameState = gameState;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            // Initialize player
            player = gameState.addPlayer(socket);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                processCommand(inputLine, out);
            }
        } catch (IOException e) {
            System.out.println("Exception in GameServerHandler: " + e.getMessage());
        } finally {
            gameState.removePlayer(player);
        }
    }

    private void processCommand(String command, PrintWriter out) {
        // Example processing logic
        switch (command.toLowerCase()) {
            case "/stop":
                gameState.handleStopCommand(player);
                break;
            case "/encore":
                gameState.handleEncoreCommand(player);
                break;
            case "/statut":
                out.println(gameState.getCurrentStatus(player));
                break;
            case "/classement":
                out.println(gameState.getRanking());
                break;
            case "/quitter":
                gameState.removePlayer(player);
                break;
            case "/aide":
                out.println("Commandes disponibles: /stop, /encore, /statut, /classement, /quitter");
                break;
            default:
                out.println("Commande inconnue. Tapez /aide pour la liste des commandes.");
        }
    }
}
