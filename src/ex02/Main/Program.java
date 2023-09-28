package src.ex02.Main;

import src.ex02.ArgumentProcessor.*;
import src.ex02.Array.*;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        ArgumentProcessor argumentProcessor = new ArgumentProcessor();
        if (!argumentProcessor.processArguments(args)) {
            System.err.println("Please provide correct arguments");
            System.exit(-1);
        }
        int[] arr = RandomArray.randomArray(argumentProcessor.getArraySize());
        System.out.println("Sum: " + Arrays.stream(arr).sum());
        try {
            printResult(Summing.createAndStartThreads(arr, argumentProcessor.getThreadsCount()));

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printResult(SummingThread[] threads) {
        int sumByThreads = 0;
        for (SummingThread thread : threads) {
            sumByThreads += thread.getSubArraySum();
            System.out.println("Thread " + thread.getThreadNumber() + ": from " + thread.getBeginIndex() + " to " + (thread.getEndIndex() - 1) + " sum is " + thread.getSubArraySum());
        }
        System.out.println("Sum by threads: " + sumByThreads);
    }
}