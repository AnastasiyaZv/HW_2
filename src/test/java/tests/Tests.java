
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stepup.Metods;

import java.util.Arrays;
import java.util.List;

import static data.RandomData.randomArray;
import static data.RandomData.randomInt;


public class Tests {
    @BeforeEach
    void printLineStart(){
        System.out.println("========================Test method start");
    }
    @AfterEach()
    void printLineEnd(){
        System.out.println("========================Test method end");
    }

    @Test
    @Tag("Smoke")
    void isEventTest(){
        int num = 4;
        System.out.println(Metods.isEven(num));
    }

    @RepeatedTest(1)
    @Tag("Smoke")
    void checkAccessTest(){
        int num = randomInt();
        System.out.println(num);
        System.out.println(Metods.checkAccess(num));
    }

    @ParameterizedTest
    @MethodSource("data.RandomData#randomArray")
    void getGradeTest(List<int[]> array) {
          for (int i = 0; i < array.size(); i++) {
            System.out.println("Массив #" + i + ": " + Arrays.toString(array.get(i)));
        }
    }
    @Test
    void getArray(){
        System.out.println(randomArray());
    }
}
