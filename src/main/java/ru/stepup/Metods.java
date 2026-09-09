package ru.stepup;

public class Metods {
    //Задача 1: метод возвращает true, если число чётное, и false — если нечётное.
    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    //Задача 2: метод возвращает Allowed, если число строго больше 18, и Denied — если меньше.
    public static String checkAccess(int age) {
        return ((age > 18) ? "Allowed" : "Denied");
    }
}
