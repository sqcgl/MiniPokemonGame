public class Move {
    private final String name;
    private final Type type;
    private final int power;

    public Move(String name, Type type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}
