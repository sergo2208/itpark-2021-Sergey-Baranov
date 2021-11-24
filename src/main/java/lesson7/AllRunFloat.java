package lesson7;

public class AllRunFloat {
    public static void main(String[] args) {
        Cat vasia = new Cat();
        vasia.name = "Вася";
        vasia.running = 200;
        vasia.floats = false;

        Dog sharik = new Dog();
        sharik.name = "Шарик";
        sharik.running = 500;
        sharik.floats = 10;

        Tiger rex = new Tiger();
        rex.name = "Рекс";
        rex.running = 1000;
        rex.floats = 20;

        vasia.loat();
        System.out.println("Умеет ли " + vasia.name + " плавать: " + vasia.getFloats());
        vasia.run();
        System.out.println(vasia.name + " пробежал " + vasia.running + "м");
        sharik.setFloats(5);
        System.out.println(sharik.name + " проплыл " + sharik.getFloats() + "м");
        sharik.run();
        System.out.println(sharik.name + " пробежал " + sharik.running + "м");
        rex.loat();
        System.out.println(rex.name + " проплыл " + rex.floats+ "м");
        rex.run();
        System.out.println(rex.name + " пробежал " + rex.running + "м");
    }

}
