package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static data.RandomData.randomArrayString;
import static data.RandomData.randomInt;
import static ru.stepup.Metods.*;

public class RepeatTests {
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

    @RepeatedTest(5)
    void checkAccessTest() {
        int num = randomInt(0, 100);
        if ((num > 18 && checkAccess(num).equals("Allowed")) || (num < 18 && checkAccess(num).equals("Denied"))) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(3)
    void sumToNTest() {
        int num = randomInt(0, 100);
        int actual = sumToN(num);
        int expected = num;
        for (int i = 0; i < num; i++) {
            expected = expected + i;
        }
        System.out.println(actual == expected ? "TEST PASSED" : "TEST FAILED");
    }

    @RepeatedTest(7)
    void hasBugTest() {
        String[] array = randomArrayString(10);

        boolean actual = hasBug(array);
        boolean expected = Arrays.asList(array).contains("Bug");

        System.out.println(actual == expected ? "TEST PASSED" : "TEST FAILED");
    }

    @RepeatedTest(3)
    void reverseTest() {
        String[] array = randomArrayString(10);

        List<String> list = new ArrayList<>(Arrays.asList(array));
        Collections.reverse(list);
        String[] reversArr = list.toArray(new String[0]);

        System.out.println(Arrays.equals(reverse(array), reversArr) ? "TEST PASSED" : "TEST FAILED");
    }
}
