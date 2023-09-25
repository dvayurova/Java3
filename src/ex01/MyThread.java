package src.ex01;

public class MyThread extends Thread {
    private int count;
    private String message;
    private Printer printer;

    public MyThread(int count, String message, Printer printer) {
        this.count = count;
        this.message = message;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            printer.print(message);
        }
    }
}
