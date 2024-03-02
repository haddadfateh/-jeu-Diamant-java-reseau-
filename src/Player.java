import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<Card> collectedCards = new ArrayList<>();
    private boolean inRound = true;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addCard(Card card) {
        collectedCards.add(card);
    }

    public void stop() {
        inRound = false;
    }

    public boolean isInRound() {
        return inRound;
    }

    public void addScore(int score) {
        this.score += score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getCollectedCards() {
        return collectedCards;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
