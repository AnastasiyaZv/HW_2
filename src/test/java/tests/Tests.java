package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static data.RandomData.randomArrayInt;
import static data.RandomData.randomInt;
import static ru.stepup.Metods.*;

public class Tests {
    @BeforeEach
    void printLineStart() {
        System.out.println("========================");
        System.out.println("Test method start");
    }

    @AfterEach()
    void printLineEnd() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    @Test
    void isEventTest() {
        int num = randomInt(0, 100);
        System.out.println(num);
        boolean expected = (num % 2 == 0);
        System.out.println("expected = " + expected);
        boolean actual = isEven(num);
        System.out.println("actual = " + actual);
        System.out.println(expected == actual ? "TEST PASSED" : "TEST FAILED");
    }

    @Test
    void blastOffTest() {
        int num = randomInt(0, 10);
        System.out.println("num = " + num);
        String res = "";
        for (int i = num; i > 0; i--) {
            res = res + i + " ";
        }
        String expected = res + "Поехали!";
        System.out.println(blastOff(num).equals(expected) ? "TEST PASSED" : "TEST FAILED");
    }

    @Test
    void findMaxTest() {
        int[] array = randomArrayInt(10);
        int[] sorted = array.clone();

        Arrays.sort(sorted);
        int maxExpected = sorted[sorted.length - 1];

        System.out.println(findMax(array) == maxExpected ? "TEST PASSED" : "TEST FAILED");
    }

    @Test
    void calcAverageTest() {
        int[] array = randomArrayInt(15);

        List<Integer> list = new ArrayList<>();
        for (int elem : array) {
            list.add(elem);
        }

        int sum = 0;
        for (int elem : list) {
            sum += elem;
        }

        System.out.println((sum / list.size() == calcAverage(list)) ? "TEST PASSED" : "TEST FAILED");
    }
}
