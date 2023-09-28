package src.ex02.Array;

public class SummingThread extends Thread {

    private int beginIndex;
    private int endIndex;
    private int[] arr;
    private int  threadNumber;
    private int sum;

    public SummingThread(int beginIndex, int endIndex, int[] arr, int threadNumber) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.arr = arr;
        this.threadNumber = threadNumber;
    }

    public int getSubArraySum() {
        return sum;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    @Override
    public void run() {
        for (int i = beginIndex; i < endIndex; i++) {
            sum += arr[i];
        }
    }
}
