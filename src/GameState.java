import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GameState {
    private final List<Player> players = new ArrayList<>();
    private final ConcurrentHashMap<Player, Socket> playerSockets = new ConcurrentHashMap<>();

    public synchronized Player addPlayer(Socket socket) {
        // Assuming Player class has a constructor that takes a unique identifier (e.g., name or socket)
        Player player = new Player("UniquePlayerName");
        players.add(player);
        playerSockets.put(player, socket);
        return player;
    }

    public synchronized void removePlayer(Player player) {
        players.remove(player);
        playerSockets.remove(player);
    }

    public synchronized void handleStopCommand(Player player) {
        // Logic for when a player decides to stop
    }

    public synchronized void handleEncoreCommand(Player player) {
        // Logic for when a player decides to continue
    }

    public String getCurrentStatus(Player player) {
        // Example status; customize according to your game logic
        return "Game status for player " + player.getName();
    }

    public String getRanking() {
        // Builds a ranking summary based on player scores
        StringBuilder ranking = new StringBuilder("Player Rankings:\n");
        players.forEach(p -> ranking.append(p.getName()).append(": ").append(p.getScore()).append("\n"));
        return ranking.toString();
    }

    // Additional methods for game logic (round management, score calculation, etc.) as needed
}
