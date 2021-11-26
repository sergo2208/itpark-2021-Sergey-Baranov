package lesson8;

public class Voice {

    public static void main(String[] args) {
        Cow cow = new Cow("Зорька", "Чёрный", 400, "Мычит");
        Dog dog = new Dog("Шарик", "Серый", 40, "Гавкает");
        Cat cat = new Cat("Вася", "Рыжий", 7, "Мяукает");
        System.out.println("Корова" + cow);
        System.out.println("Собака" + dog);
        System.out.println("Кот" + cat);
        cow.giveMilk();
        dog.protectTheHouse();
        cat.catchingMice();

        Cow cow1 = new Cow("Зорька", "Чёрный", 400, "Громко мычит");
        cow.changeVoice();
        System.out.println(cow1);

        Dog dog1 = new Dog("Шарик", "Серый", 40, "Воет");
        dog.changeVoice();
        System.out.println(dog1);

        Cat cat1 = new Cat("Вася", "Рыжий", 7, "Мурлычет");
        cat.changeVoice();
        System.out.println(cat1);
    }

}

