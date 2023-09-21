public class Program {

    private static final String EGG = "Egg";
    private static final String HEN = "Hen";
    private static final String HUMAN = "Human";

    public static void main(String[] args) {
        int count = ArgumentProcessor.getCount(args);
        if (count < 0) System.exit(-1);
        MyThread egg = new MyThread(count, EGG);
        MyThread hen = new MyThread(count, HEN);
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            System.err.println("Something wrong " + e.getMessage());
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(HUMAN);
        }
    }
}