import java.util.Collections;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cards = new Stack<>();

    public CardDeck() {
        initializeDeck();
    }

    private void initializeDeck() {
        // Ajouter les cartes rubis
        int[] rubyValues = {1, 2, 3, 4, 5, 5, 7, 7, 9, 11, 11, 13, 14, 15, 17};
        for (int value : rubyValues) {
            cards.push(new Card(Card.Type.RUBY, value));
        }

        // Ajouter les cartes pièges (3 de chaque type)
        for (int i = 0; i < 3; i++) {
            cards.push(new Card(Card.Type.TRAP, 0)); // La valeur est 0 car les pièges n'ont pas de valeur de rubis
        }

        // Ajouter une carte relique
        cards.push(new Card(Card.Type.RELIC, 5)); // La valeur est 5 comme spécifié

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }

    // Vérifie s'il reste des cartes à tirer
    public boolean hasCards() {
        return !cards.isEmpty();
    }
}
