package lesson9;

public class Car extends Automobile {

    public Car(String carBrand, String colour, int yearOfRelease, int theMaximumDistanceThatCanBeDrivenOnOneTank) {
        super(carBrand, colour, yearOfRelease, theMaximumDistanceThatCanBeDrivenOnOneTank);
    }

    @Override
    protected void realDistance() {
        System.out.println("Реально проходимая дистанция легкового автомобиля с полным баком:");
    }

    public void moveDistance() {
        this.moveDistance(getTheMaximumDistanceThatCanBeDrivenOnOneTank());
    }
}
