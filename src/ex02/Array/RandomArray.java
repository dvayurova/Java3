package src.ex02.Array;
import java.util.Random;

public class RandomArray {
    private static final int maxAbsoluteValue = 1000;

    public static int[] randomArray(int size) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(2 * maxAbsoluteValue) - maxAbsoluteValue;
        }
        return randomArray;
    }
}
