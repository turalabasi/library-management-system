package Enums;

import java.time.LocalDateTime;

public enum ExceptionEnum {
    WRONG_FORMAT("wrong format",LocalDateTime.now()),
    NUMBER_FORMAT("number format exception",LocalDateTime.now()),
    WRONG_PARAMETER("wrong parameter",LocalDateTime.now()),
    BOOK_NOT_FOUND("book not found",LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option exception",LocalDateTime.now()),
    INVALID_EXCEPTION("Invalid exception",LocalDateTime.now()),
    CUSTOMER_NOT_FOUND("customer not found",LocalDateTime.now()),
    INPUT_MISMATCH("inputmismatch exception",LocalDateTime.now()),
    EMPTY_LIST_EXCEPTION("Empty list exception",LocalDateTime.now());


    ExceptionEnum(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    String message;
    LocalDateTime localDateTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}
