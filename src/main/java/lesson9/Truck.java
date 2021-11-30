package lesson9;

public class Truck extends Automobile {
    public Truck(String carBrand, String colour, int yearOfRelease, int theMaximumDistanceThatCanBeDrivenOnOneTank) {
        super(carBrand, colour, yearOfRelease, theMaximumDistanceThatCanBeDrivenOnOneTank);
    }

    @Override
    protected void realDistance() {
        System.out.println("Реально проходимая дистанция грузового автомобиля с полным баком:");
    }

    public void moveDistance() {
        this.moveDistance(getTheMaximumDistanceThatCanBeDrivenOnOneTank());
    }

}
