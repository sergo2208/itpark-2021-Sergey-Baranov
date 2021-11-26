package lesson8;

public class Cow extends Animals {

    public Cow(String name, String colour, int weight, String specificSound) {
        super(name, colour, weight, specificSound);
    }

    public void giveMilk() {
        System.out.println("Корова умеет давать молоко");
    }

    public void changeVoice(String newVoice) {
        super.changeVoice(newVoice);
        System.out.println("Когда корову надо подоить, она");
    }

    public void changeVoice() {
        this.changeVoice(getSpecificSound());
    }
}

