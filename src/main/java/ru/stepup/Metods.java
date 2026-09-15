package ru.stepup;

import java.util.ArrayList;
import java.util.List;

public class Metods {
    //Задача 1: метод возвращает true, если число чётное, и false — если нечётное.
    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    //Задача 2: метод возвращает Allowed, если число строго больше 18, и Denied — если меньше.
    public static String checkAccess(int age) {
        return ((age > 18) ? "Allowed" : "Denied");
    }

    //Задача 3: метод должен возвращать true, если переданное число больше или равно нулю,
    // и false, если переданное число меньше нуля.
    // Проверка внутри метода должна происходить с помощью тернарного оператора.
    public static boolean isPositive(int n) {
        boolean res = n >= 0;
        return res;
    }

    //Задача 4: метод возвращает строку, соответствующую строгому вхождению в границы:
    //• 0–20: E;
    //• 21–40: D;
    //• 41–60: C;
    //• 61–80: B;
    //• 81–100: A.
    //Если переданное число не входит в границы — вернуть строку Error.
    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) return "E";
        if (score > 20 && score <= 40) return "D";
        if (score > 40 && score <= 60) return "C";
        if (score > 60 && score <= 80) return "B";
        if (score > 80 && score <= 100) return "A";
        return "Error";
    }

    //Задача 5: метод принимает стартовое число (например, 5) и возвращает строку со всеми
    // числами до 1 и словом «Поехали!»
    // в конце (например, «5 4 3 2 1 Поехали!»).
    public static String blastOff(int start) {
        String res = "";
        for (int i = start; i > 0; i--) {
            res = res + i + " ";
        }
        return res + "Поехали!";
    }

    //Задача 6: метод возвращает сумму всех целых чисел от 1 до n.
    public static int sumToN(int n) {
        int sum = n;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    //Задача 7: метод принимает массив строк и возвращает true, если хотя бы одна строка в массиве равна Bug.
    // Сравнение можно выполнять без учёта регистра.
    public static boolean hasBug(String[] messages) {
        for (String word : messages) {
            if (word.equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    //Задача 8: метод принимает границы диапазона и возвращает строку, состоящую только из чётных чисел внутри
    //этого промежутка (включая границы), разделённых пробелом.
    //Перед первым и после последнего числа пробел не ставится. Например: (2, 5) -> “2 4”
    public static String getEvenInRange(int start, int end) {
        String res = "";
        if (start > end) return "начало диапазона больше его конца";
        for (int i = start; i < end + 1; i++) {
            if (i % 2 == 0)
                res = res + i + " ";
        }
        return res.trim();
    }

    //Задача 9: метод находит и возвращает самое большое число в переданном массиве.
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (max <= element) {
                max = element;
            }
        }
        return max;
    }

    //Задача 10: метод возвращает новый массив, в котором элементы исходного массива расположены
    // в обратном порядке.
    //Например, {“One”, “Two”, “Zero”} -> {“Zero”, “Two”, "One"}.
    public static String[] reverse(String[] arr) {
        String[] reverseArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArr[arr.length - 1 - i] = arr[i];
        }
        return reverseArr;
    }

    //Задача 11: метод вычисляет и возвращает среднее арифметическое всех чисел в списке.
    public static int calcAverage(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum / list.size();
    }

    //Задача 12: метод принимает список и имя, которое нужно исключить.
    // Возвращает новый список, не содержащий указанного имени.
    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        if (list == null) return list;
        List<String> resList = new ArrayList<>();

        for (String element : list) {
            if (!element.equals(nameToRemove)) {
                resList.add(element);
            }
        }
        return resList;
    }
}
