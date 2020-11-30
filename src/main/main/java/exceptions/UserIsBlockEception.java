package exceptions;

public class UserIsBlockEception extends RuntimeException {
    public UserIsBlockEception(String mess) {
        super(mess);
    }
}
