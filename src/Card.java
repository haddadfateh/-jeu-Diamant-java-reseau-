public class Card {
    public enum Type {
        RUBY, TRAP, RELIC
    }

    private final Type type;
    private final int value;

    public Card(Type type, int value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
