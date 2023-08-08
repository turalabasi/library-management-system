package exception;

import Enums.ExceptionEnum;

public class BookNotFoundException extends RuntimeException {
    private String message;

    public BookNotFoundException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
