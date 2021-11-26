package lesson8;

public class Dog extends Animals {

    public Dog(String name, String colour, int weight, String specificSound) {
        super(name, colour, weight, specificSound);
    }

    public void protectTheHouse() {
        System.out.println("Собака умеет защищать дом");
    }

    public void changeVoice(String newVoice) {
        super.changeVoice(newVoice);
        System.out.println("Когда собака смотрит на Луну, она");
    }

    public void changeVoice() {
        this.changeVoice(getSpecificSound());
    }
}
