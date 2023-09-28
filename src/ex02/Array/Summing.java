package src.ex02.Array;

public class Summing {

    public static SummingThread [] createAndStartThreads(int[] arr, int threadsCount) throws InterruptedException {
        int subArraySize = (arr.length + threadsCount -1) / threadsCount;

        SummingThread [] threads = new SummingThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            int end = Math.min((i + 1) * subArraySize, arr.length);
            threads[i] = new SummingThread(i * subArraySize, end, arr, i + 1);
        }
        for(SummingThread thread: threads){
            thread.start();
        }
        for(SummingThread thread: threads){
            thread.join();
        }
        return threads;
    }
}
