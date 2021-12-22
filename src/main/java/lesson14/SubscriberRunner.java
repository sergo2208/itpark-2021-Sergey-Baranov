package lesson14;

import java.util.*;

public class SubscriberRunner {

    public static void main(String[] args) {
        int subscribersAmount = 10000; // Кол-во абонентов

        // Объявление списка с будущими абонентами
        ArrayList<Subscriber> listOfSubscribers = new ArrayList<>();

        // Наполнение списка абонентов через метод
        for (int i = 0; i < subscribersAmount; i++) {
            listOfSubscribers.add(subscriberRandomGenerator());
        }

        // Создание коллекции Set и копирование в неё всех элементов ранее созданного списка абонентов

        // Создание коллекции Map и копирование в неё всех элементов ранее созданного списка абонентов
        HashMap<Integer, Subscriber> mapOfSubscriber = new HashMap<>();
        for (int k = 0; k < subscribersAmount; k++) {
            mapOfSubscriber.put(numbersForMap(k), subscriberForMap(k, listOfSubscribers));
        }

        // список абонентов наполнен, добавляем каждому абоненту 100 других связанных с ним
        // Код ниже любезно предоставлен преподаваетелем
        Random random = new Random();
        for (Subscriber listOfSubscriber : listOfSubscribers) {
            for (int i = 0; i < 100; i++) {
                Subscriber randomSubscriber;
                randomSubscriber = listOfSubscribers.get(random.nextInt(listOfSubscribers.size()));
                listOfSubscriber.getBoundedSubscribers().add(randomSubscriber);
            }
        }

        // Поиск самого часто встречающегося номера из числа связанных
        // Создание списка для хранения тел. номеров
        Long[] array = new Long[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (long) (i + 100);
        }

        // Создание коллекции Set для временного хранения сотни номеров (они тоже в Set)
        HashSet<Subscriber> setForNumber = new HashSet<>();

        // Цикл проходит по всем абонентам и извлекает колекцию связанных абонентов
        for (int i = 0, j = 100, k = 0; i < subscribersAmount; i++) {
            // Сущность для временного хранения одного абонента
            Subscriber tempSubscriber;
            tempSubscriber = listOfSubscribers.get(i);
            // наполнение временной коллекции сотней абонентов
            setForNumber.addAll(tempSubscriber.getBoundedSubscribers());
            // втроенный цикл для пробега по колллекции из сотни связанных абонентов
            for (Subscriber tempS : setForNumber) {
                long t = tempS.getTelNumber();
                // каждый из сотни номеров добавляется в массив
                array[j + k] = t;
                k++;
            }
            j = j + 100;
            k = 0;
        }
        System.out.println("Самый часто повторяющийся номер в связанных номерах: " + mostPopularPhoneNumber(array));
    }

    // взятый из инета метод генерации случайных строк для создания имени абонентов
    public static String getRandomFIO() {
        Random random = new Random();
        int length = random.nextInt(30) + 15;
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    // создание объектов абонентов со случайными параметрами
    public static Subscriber subscriberRandomGenerator() {
        return new Subscriber(getRandomFIO(), randomPhoneNumber());
    }

    // метод генерации случайного тел. номера от 80000000000 до 89999999999
    public static long randomPhoneNumber() {
        long max = 89999999999L;
        long min = 80000000000L;
        max -= min;
        return (long) (Math.random() * ++max) + min;
    }

    // Метод, возвращающий число (от 1 до 10000) в качестве ключа для Map
    public static int numbersForMap(int i) {
        return (i++) - 1;
    }

    // Метод, возвращающий объект абонента из списка (по-порядку)
    public static Subscriber subscriberForMap(int k, ArrayList<Subscriber> list) {
        return list.get(k);
    }

    // взятый из инета метод для поиска самого часто встречающегося элемента в массиве
    public static Long mostPopularPhoneNumber(Long[] array) {

        long[] counts = new long[100000];
        int maxCount = 0;
        int maxKey = 0;

        for (Long aLong : array) {
            try {
                counts[Math.toIntExact(aLong)]++;
            } catch (Exception e) {
                if (maxKey == 100) {
                    break;
                }
            }

            try {
                if (counts[Math.toIntExact(aLong)] > maxCount) {
                    maxCount = Math.toIntExact(counts[Math.toIntExact(aLong)]);
                    maxKey = Math.toIntExact(aLong);
                }
            } catch (Exception e) {
                if (maxKey == 100) {
                    break;
                }
            }
            if (maxKey == 100) {
                break;
            }
        }
        return (long) maxKey;
    }
}
