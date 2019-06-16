package Handler;

public class InvalidFormattingException extends Exception {

    private static String Error = "An invalid format has been detected";


    public InvalidFormattingException() {
        super(InvalidFormattingException.Error);
    }


    public InvalidFormattingException(String message) {
        super(InvalidFormattingException.Error + "\n" + message);
    }
}

