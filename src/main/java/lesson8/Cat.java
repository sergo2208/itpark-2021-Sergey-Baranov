package lesson8;

public class Cat extends Animals {

    public Cat(String name, String colour, int weight, String specificSound) {
        super(name, colour, weight, specificSound);
    }

    public void catchingMice() {
        System.out.println("Кот умеет ловить мышей");
    }

    public void changeVoice(String newVoice) {
        super.changeVoice(newVoice);
        System.out.println("Когда кота гладят, он");
    }

    public void changeVoice() {
        this.changeVoice(getSpecificSound());
    }
}
