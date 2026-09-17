package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static data.RandomData.randomArrayInt;
import static data.RandomData.randomInt;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.stepup.Metods.*;

@Tag("Smoke")
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
        boolean expected = (num % 2 == 0);
        boolean actual = isEven(num);
        assertThat(actual)
                .as(String.format("Проверяемое значение: %d. " +
                                "Фактический результат: %s не соответствует ожидаемому результату: %s.",
                        num, actual, expected))
                .isEqualTo(expected);
    }


    @Test
    void blastOffTest() {
        int num = randomInt(0, 10);
        String actual = blastOff(num);

        String res = "";
        for (int i = num; i > 0; i--) {
            res = res + i + " ";
        }
        String expected = res + "Поехали!";

        assertThat(actual)
                .as(String.format("Проверяемое значение: %d. " +
                                "Фактический результат: %s не соответствует ожидаемому результату: %s.",
                        num, actual, expected))
                .isEqualTo(expected);
    }

    @Test
    void findMaxTest() {
        int[] array = randomArrayInt(10);
        int[] sorted = array.clone();

        int actual = findMax(array);
        Arrays.sort(sorted);
        int expected = sorted[sorted.length - 1];

        assertThat(actual)
                .as(String.format("Проверяемый массив %s. " +
                                "Фактическое максимальное значение: %d не соответствует ожидаемому результату: %d.",
                        Arrays.toString(array), actual, expected))
                .isEqualTo(expected);
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

        int actual = calcAverage(list);
        int expected = sum / list.size();

        assertThat(actual)
                .as(String.format("Фактическое максимальное значение: %d не соответствует ожидаемому результату: %d.",
                        actual, expected))
                .isEqualTo(expected);
    }
}
