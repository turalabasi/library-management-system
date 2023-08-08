package exception;

import Enums.ExceptionEnum;

public class InvalidOptionExceptions extends  RuntimeException {
    private  String message;

    public InvalidOptionExceptions(ExceptionEnum exceptionEnum) {
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
