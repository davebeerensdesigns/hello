package nl.novi.hello.exception;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException{

    @Serial
    private static final long SerialVersionUID = 1L;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
