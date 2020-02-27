package common;

public class Validation {
    public static void requireNonEmptyString(String arg, String message){
        if(arg == null || arg.trim().isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireNonNull(Object arg , String message){
        if(arg == null){
            throw new NullPointerException(message);
        }
    }
}
