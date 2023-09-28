package src.ex02.ArgumentProcessor;

public class ArgumentProcessor {
    private int arraySize;
    private int threadsCount;


    public int getArraySize() {
        return arraySize;
    }

    public int getThreadsCount() {
        return threadsCount;
    }

    public boolean processArguments(String[] args) {
        if (!Validator.isValidArgs(args)) {
            return false;
        }
        if ((arraySize = parseNumber(args[0])) == -1 || arraySize > 2000000) {
            System.err.println("Maximum number of array elements is 2,000,000");
            return false;
        }
        if (((threadsCount = parseNumber(args[1])) == -1) || threadsCount > arraySize) {
            System.err.println("Maximum number of threads is no greater than current number of array elements");
            return false;
        }
        return true;
    }

    private int parseNumber(String arg) {
        int number;
        try {
            number = Integer.parseInt(arg.substring(arg.indexOf("=") + 1));
        } catch (NumberFormatException e) {
            System.err.println("Provided argument is not a number");
            return -1;
        }
        if (number <= 0) {
            System.err.println("Please provide a positive number");
            return -1;
        }
        return number;
    }
}
