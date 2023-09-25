package src.ex01;

public class ArgumentProcessor {
    public static int getCount(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Program --count=NUMBER");
            return -1;
        }
        int count = parseCount(args[0]);
        return count;
    }

    private static int parseCount(String arg) {
        if (!arg.startsWith("--count=")) {
            System.err.println("Please provide argument in format: \"--count=NUMBER\"");
            return -1;
        }
        int count;
        try {
            count = Integer.parseInt(arg.substring(arg.indexOf("=") + 1));
        } catch (NumberFormatException e) {
            System.err.println("Provided argument is not a number");
            return -1;
        }
        if (count <= 0) {
            System.err.println("Please provide a positive number as a count");
            return -1;
        }
        return count;
    }
}
