package lesson9;

public class Launcher {
    public static void main(String[] args) {
        Car audi = new Car("audi", "Серый", 2019,
                500);
        Car bmw = new Car("bmw", "Белый", 2018,
                500);
        Car lada = new Car("lada", "Красный", 2020,
                500);
        Car volvo = new Car("volvo", "Синий", 2021,
                500);
        Car ford = new Car("ford", "Чёрный", 2017,
                500);
        Truck man = new Truck("man", "Серый", 2016,
                1200);
        Truck maz = new Truck("maz", "Белый", 2021,
                1200);
        Truck scania = new Truck("scania", "Жёлтый", 2020,
                1200);
        Truck zil = new Truck("zil", "Голубой", 2018,
                1200);
        Truck kamaz = new Truck("kamaz", "Синий", 2019,
                1200);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(lada);
        System.out.println(volvo);
        System.out.println(ford);
        System.out.println(man);
        System.out.println(maz);
        System.out.println(scania);
        System.out.println(zil);
        System.out.println(kamaz);
        System.out.println("-------------------------------------------");
        audi.realDistance();
        Car audi1 = new Car("audi", "Серый", 2019,
                490);
        audi.moveDistance();
        System.out.println(audi1);
        System.out.println("--------------------------------------------");
        bmw.realDistance();
        Car bmw1 = new Car("bmw", "Белый", 2018,
                480);
        bmw.moveDistance();
        System.out.println(bmw1);
        System.out.println("---------------------------------------------");
        lada.realDistance();
        Car lada1 = new Car("lada", "Красный", 2020,
                400);
        lada.moveDistance();
        System.out.println(lada1);
        System.out.println("--------------------------------------------");
        volvo.realDistance();
        Car volvo1 = new Car("volvo", "Синий", 2021,
                470);
        volvo.moveDistance();
        System.out.println(volvo1);
        System.out.println("--------------------------------------------");
        ford.realDistance();
        Car ford1 = new Car("ford", "Чёрный", 2017,
                450);
        ford.moveDistance();
        System.out.println(ford1);
        System.out.println("--------------------------------------------");
        man.realDistance();
        Truck man1 = new Truck("man", "Серый", 2016,
                990);
        man.moveDistance();
        System.out.println(man1);
        System.out.println("--------------------------------------------");
        maz.realDistance();
        Truck maz1 = new Truck("maz", "Белый", 2021,
                900);
        maz.moveDistance();
        System.out.println(maz1);
        System.out.println("--------------------------------------------");
        scania.realDistance();
        Car scania1 = new Car("scania", "Жёлтый", 2020,
                995);
        scania.moveDistance();
        System.out.println(scania1);
        System.out.println("--------------------------------------------");
        zil.realDistance();
        Truck zil1 = new Truck("zil", "Голубой", 2018,
                890);
        zil.moveDistance();
        System.out.println(zil1);
        System.out.println("--------------------------------------------");
        kamaz.realDistance();
        Truck kamaz1 = new Truck("kamaz", "Синий", 2019,
                940);
        kamaz.moveDistance();
        System.out.println(kamaz1);
        System.out.println("--------------------------------------------");
    }

}
