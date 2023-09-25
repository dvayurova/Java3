package src.ex01;

public class Program {
    private static final String EGG = "Egg";
    private static final String HEN = "Hen";

    public static void main(String[] args) {
        int count = ArgumentProcessor.getCount(args);
        if (count < 0) System.exit(-1);
        Printer printer = new Printer();
        MyThread egg = new MyThread(count, EGG, printer);
        MyThread hen = new MyThread(count, HEN, printer);
        egg.start();
        hen.start();
    }
}