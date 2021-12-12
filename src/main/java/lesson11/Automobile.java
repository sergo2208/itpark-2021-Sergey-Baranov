package lesson11;

public class Automobile {

    private String model;
    private String stateNumber;
    private double width;
    private double height;
    private double weight;
    private int speed;


    public String getModel() {
        return model;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public Automobile(String model, String stateNumber, double width, double height, double weight, int speed) {
        this.model = model;
        this.stateNumber = stateNumber;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }
}


