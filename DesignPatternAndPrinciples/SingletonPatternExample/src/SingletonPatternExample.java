public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Initializing system components.");
        logger2.log("Connection established successfully.");

        if (logger1 == logger2) {
            System.out.println("Verification: Both references point to the same Logger instance.");
        } else {
            System.out.println("Verification: Error! Instances are different.");
        }
    }
}
