package lesson9;

public abstract class Automobile {
    public String carBrand;
    public String colour;
    public int yearOfRelease;
    public int theMaximumDistanceThatCanBeDrivenOnOneTank;

    public Automobile(String carBrand, String colour, int yearOfRelease,
                      int theMaximumDistanceThatCanBeDrivenOnOneTank) {
        this.carBrand = carBrand;
        this.colour = colour;
        this.yearOfRelease = yearOfRelease;
        this.theMaximumDistanceThatCanBeDrivenOnOneTank = theMaximumDistanceThatCanBeDrivenOnOneTank;
    }

    public String toString() {
        return " brand '" + carBrand + '\'' +
                ", colour '" + colour + '\'' +
                ", year of release = " + yearOfRelease +
                ", the maximum distance '" + theMaximumDistanceThatCanBeDrivenOnOneTank + '\'';
    }

    protected abstract void realDistance();

    public void moveDistance(int realDistance) {
        this.theMaximumDistanceThatCanBeDrivenOnOneTank = realDistance;
    }

    public int getTheMaximumDistanceThatCanBeDrivenOnOneTank() {
        return theMaximumDistanceThatCanBeDrivenOnOneTank;
    }
}

