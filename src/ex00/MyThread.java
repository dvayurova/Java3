public class MyThread extends Thread {
    private int count;
    private String message;

    public MyThread(int count, String message) {
        this.count = count;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}
