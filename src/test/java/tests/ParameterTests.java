package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.stepup.Metods.*;

@Tag("Parameter")
public class ParameterTests {
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

    @ParameterizedTest(name = "score={0} -> grade={1}")
    @CsvSource({
            "0,   E",
            "10,  E",
            "20,  E",
            "21,  D",
            "40,  D",
            "41,  C",
            "60,  C",
            "61,  B",
            "80,  B",
            "81,  A",
            "100, A",
            "-10, Error"
    })
    void getGradeTest(int score, String expected) {
        String actual = getGrade(score);
        assertThat(actual)
                .as(String.format("Число %d не соответствует диапазону %s. " + "\n" +
                                "Фактический результат: %s не соответствует ожидаемому: %s",
                        score, expected, actual, expected))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataIsPositiveTest.csv",
            numLinesToSkip = 1
    )
    void isPositiveTest(int n, boolean expected) {
        boolean actual = isPositive(n);

        assertThat(actual)
                .as(String.format("Фактический результат: %s не соответствует ожидаемому результату: %s.",
                        actual, expected))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataGetEvenInRangeTest.csv",
            numLinesToSkip = 1
    )
    void getEvenInRangeTest(int start, int end, String expected) {
        String actual = getEvenInRange(start, end);

        assertThat(actual)
                .as(String.format("Проверяемый диапазон: [%d, %d]" + "\n" +
                                "Фактический результат: %s не соответствует ожидаемому результату: %s.",
                        start, end, actual, expected))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataRemoveSpecificNameTest.csv",
            delimiter = ';',
            numLinesToSkip = 1
    )
    void removeSpecificNameTest(String inputList, String word, String expectedList) {

        List<String> list = Arrays.asList(inputList.split(","));
        List<String> actualList = removeSpecificName(list, word);

        assertThat(actualList)
                .as(String.format("Список %s содержит слово %s.",
                        actualList, word))
                .isNotEmpty()
                .doesNotContain(word);
    }
}
