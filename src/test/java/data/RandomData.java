package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomData {
    static final String[] DICTIONARY = {
            "apple", "banana", "cherry", "elderberry",
            "fig", "grape", "kiwi", "lemon",
            "mango", "nectarine", "orange", "papaya",
            "raspberry", "strawberry", "vanilla", "Bug"
    };
    static Random random = new Random();

    public static int randomInt(int a, int b) {
        return random.nextInt(a, b);
    }

    public static List<int[]> randomList() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new int[]{random.nextInt(0, 101)});
        }
        return list;
    }

    public static int[] randomArrayInt(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    public static String[] randomArrayString(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(DICTIONARY.length);
            array[i] = DICTIONARY[index];
        }
        return array;
    }
}
