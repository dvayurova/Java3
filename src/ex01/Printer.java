package src.ex01;

public class Printer {
    private String previousMessage = "Hen";

    public synchronized void print(String message) {

        while (message.equals(previousMessage)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Something wrong " + e.getMessage());
                return;
            }
        }
        System.out.println(message);
        previousMessage = message;
        notifyAll();

    }
}

