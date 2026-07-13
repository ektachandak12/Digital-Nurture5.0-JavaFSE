public class SingletonPattern {

    // Logger Class
    static class Logger {

        private static Logger instance;

        private Logger() {
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        System.out.println();

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance is created.");
        } else {
            System.out.println("Multiple Logger instances are created.");
        }

        System.out.println("Logger1 HashCode : " + logger1.hashCode());
        System.out.println("Logger2 HashCode : " + logger2.hashCode());
    }
}