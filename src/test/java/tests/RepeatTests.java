package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static data.RandomData.randomArrayString;
import static data.RandomData.randomInt;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.stepup.Metods.*;

@Tag("Repeat")
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

    @RepeatedTest(10)
    void checkAccessTest() {
        int num = randomInt(0, 100);
        String expected = "";
        String actual = checkAccess(num);

        if (num > 18) {
            expected = "Allowed";
        } else expected = "Denied1";

        assertThat(actual)
                .as(String.format("Проверяемое число %d. " + "\n" +
                        "Фактический результат: %s не соответствует ожидаемому результату: %s.",
                num, actual, expected))
                .isEqualTo(expected);

    }

    @RepeatedTest(10)
    void sumToNTest() {
        int num = randomInt(0, 100);
        int actual = sumToN(num);
        int expected = num;
        for (int i = 0; i < num; i++) {
            expected = expected + i;
        }

        assertThat(actual)
                .as(String.format("Сумма не верная. " + "\n" +
                                "Фактический результат: %d не соответствует ожидаемому результату: %d.",
                        actual, expected))
                .isEqualTo(expected);

    }

    @RepeatedTest(10)
    void hasBugTest() {
        String[] array = randomArrayString(10);
        String findWord = "Bug";
        boolean actual = hasBug(array);
        boolean expected = Arrays.asList(array).contains(findWord);

        assertThat(actual)
                .as(String.format("Проверяемый массив: %s." + "\n" + "Искомое значение: %s" + "\n" +
                                "Фактический результат: %s не соответствует ожидаемому результату: %s.",
                        Arrays.toString(array), findWord, actual, expected))
                .isEqualTo(expected);
    }

    @RepeatedTest(10)
    void reverseTest() {
        String[] array = randomArrayString(10);
        String[] actualArr = reverse(array);

        List<String> list = new ArrayList<>(Arrays.asList(array));
        Collections.reverse(list);
        String[] expectedArr = list.toArray(new String[0]);

        assertThat(actualArr)
                .as("Фактический результат не соответствует ожидаемому результату.")
                .containsExactly(expectedArr);
    }
}
