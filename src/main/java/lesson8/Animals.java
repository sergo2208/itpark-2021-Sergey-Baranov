package lesson8;

public class Animals {
    private String name;
    private String colour;
    private int weight;
    private String specificSound;

    public Animals(String name, String colour, int weight, String specificSound) {
        this.name = name;
        this.colour = colour;
        this.weight = weight;
        this.specificSound = specificSound;
    }

    public void changeVoice(String newVoice) {
        this.specificSound = newVoice;
    }

    public String getSpecificSound() {
        return specificSound;
    }

    public String toString() {
        return " name '" + name + '\'' +
                ", color '" + colour + '\'' +
                ", weight = " + weight +
                ", specificSound '" + specificSound + '\'';
    }
}

