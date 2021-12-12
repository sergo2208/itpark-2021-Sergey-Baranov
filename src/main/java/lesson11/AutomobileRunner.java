package lesson11;

public class AutomobileRunner {

    public static void main(String[] args) {

        Automobile auto1 = new Automobile("volga21", "С251ПА69",1.8,
                1.42, 1.875, 75);
        Automobile auto2 = new Automobile("MAN", "Р148ЖД78", 2.5,
                3.78, 18.1, 75);
        Automobile auto3 = new Automobile("ГАЗель", "В589НЕ26", 2.1,
                2.12, 2.3, 85);
        Automobile auto4 = new Automobile("ГАЗель", "Н354ЗЛ77", 2.1,
                2.12, 2.9, 67);
        Automobile auto5 = new Automobile("Уаз", "В154НВ69", 1.7,
                1.4, 2.200, 75);
        Automobile auto6 = new Automobile("Audi", "C126CC78", 1.74,
                1.6, 1.8, 240);
        Automobile auto7 = new Automobile("Зил", "В212ЕВ178",2.5,
                2.5, 4.3, 70);
        Automobile auto8 = new Automobile("Камаз", "В215ОН36",2.55,
                3.7, 7.08, 70);
        Automobile auto9 = new Automobile("Маз", "О256МО69", 2.5,
                4.3, 7.100,75);
        Automobile auto10 = new Automobile("BMB", "B156CB63", 1.88,
                1.7, 1.7, 240);
        Automobile auto11 = new Automobile("Opel Antara", "B023AB178",
                1.85, 1.7, 1.75, 95);
        Automobile auto12 = new Automobile("Dodge Caliber", "E546EO36",
                1.74, 1.8, 1.9, 87);
        Automobile auto13 = new Automobile("Daf", "P326MO62",
                2.55, 3.8, 19, 80 );
        Automobile auto14 = new Automobile("Маз", "P123PP189",
                2.5, 4.1, 7.0, 75);
        Automobile auto15 = new Automobile ("Зил", "A562PA36", 2.5,
                3.7, 4.3, 80);
        Automobile auto16 = new Automobile("Камаз", "E056MM56",
                2.5, 3.78, 7.08, 70);
        Automobile auto17 = new Automobile("Daf", "K126EA78",
                2.55, 3.8, 19.0, 75 );
        Automobile auto18 = new Automobile("ГАЗель", "H539НB27", 2.1,
                2.12, 8.3, 70);
        Automobile auto19 = new Automobile("ГАЗель", "В238НK23", 2.1,
                2.12, 10.1, 75);
        Automobile auto20 = new Automobile("volga21", "P232PB69",1.8,
                1.42, 1.875, 70);

        Automobile[] autos = new Automobile[]{auto1, auto2, auto3, auto4, auto5,
                auto6, auto7, auto8, auto9, auto10, auto11, auto12, auto13,
                auto14, auto15, auto16, auto17, auto18, auto19, auto20};
        for (Automobile auto : autos) {
            try {
                if (auto.getSpeed() > 80 & auto.getSpeed() < 100)
                    throw new IllegalArgumentException(auto.getModel() + " с номером " +
                            auto.getStateNumber() + ", Ваша скорость " + auto.getSpeed() +
                            "км/ч, пожалуйста, снизьте скорость!");
                if (auto.getSpeed() >= 100)
                    throw new IllegalArgumentException(auto.getModel() + " с номером " +
                            auto.getStateNumber() + ", Ваша скорость " + auto.getSpeed() +
                            "км/ч! За Вами отправлен патруль ДПС");
                if (auto.getHeight() > 4)
                    throw new IllegalArgumentException(auto.getModel() + " с номером " +
                            auto.getStateNumber() + ", Ваша высота " + auto.getHeight() +
                            "м превышает 4м. Проезд на КПП запрещен.");
                if (auto.getWidth() > 2.5)
                    throw new IllegalArgumentException(auto.getModel() + " с номером " +
                            auto.getStateNumber() + ", Ваша ширина " + auto.getWidth() +
                            "м превышает 2,5м. Проезд на КПП запрещен.");
                if (auto.getWeight() > 8)
                    throw new IllegalArgumentException(auto.getModel() + " с номером " +
                            auto.getStateNumber() + ", Ваш вес " + auto.getWeight() +
                            "т превышает 8т. Проезд на КПП запрещен.");
                System.out.println(auto.getModel() + " с номером " +
                        auto.getStateNumber() + ", предъявите пропуск на КПП");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}




