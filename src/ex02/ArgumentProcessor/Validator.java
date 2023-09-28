package src.ex02.ArgumentProcessor;

public class Validator {
    public static boolean isValidArgs(String[] args){
        if (args.length != 2) {
            System.err.println("Usage: --arraySize=NUMBER --threadsCount=NUMBER");
            return false;
        }
        if (!args[0].startsWith("--arraySize=")) {
            System.err.println("Please provide array size in format: \"--arraySize=\"");
            return false;
        }
        if (!args[1].startsWith("--threadsCount=")) {
            System.err.println("Please provide threads count in format: \"--threadsCount=\"");
            return false;
        }
        return true;
    }
}
