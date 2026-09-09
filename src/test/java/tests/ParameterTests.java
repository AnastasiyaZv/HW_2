package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static ru.stepup.Metods.*;

public class ParameterTest {
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

    @ParameterizedTest
    @MethodSource("data.RandomData#randomList")
    void getGradeTest(int[] array) {
        int score = array[0];
        boolean passed = false;
        switch (score) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 ->
                    passed = getGrade(score).equals("E");

            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 ->
                    passed = getGrade(score).equals("D");

            case 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 ->
                    passed = getGrade(score).equals("C");

            case 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 ->
                    passed = getGrade(score).equals("B");

            case 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 ->
                    passed = getGrade(score).equals("A");

            default -> passed = getGrade(score).equals("Error");
        }

        System.out.println(passed ? "TEST PASSED" : "TEST FAILED");
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataIsPositiveTest.csv",
            numLinesToSkip = 1
    )
    void isPositiveTest(int n, boolean expected) {
        boolean actual = isPositive(n);
        System.out.println(expected == actual ? "TEST PASSED" : "TEST FAILED");
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataGetEvenInRangeTest.csv",
            numLinesToSkip = 1
    )
    void getEvenInRangeTest(int start, int end, String expected) {
        System.out.println(getEvenInRange(start, end).equals(expected) ? "TEST PASSED" : "TEST FAILED");
    }
    @ParameterizedTest
    @CsvFileSource(
            resources = "/dataRemoveSpecificNameTest.csv",
            delimiter = ';',
            numLinesToSkip = 1
    )
    void removeSpecificNameTest(String inputList, String word, String expectedList) {

        List<String> list = Arrays.asList(inputList.split(","));
        List<String> listExpected = Arrays.asList(expectedList.split(","));
        List<String> listActual = removeSpecificName(list, word);

        System.out.println(listExpected.equals(listActual) ? "TEST PASSED" : "TEST FAILED");
    }
}
