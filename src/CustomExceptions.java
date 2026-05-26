public class CustomExceptions {

}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) { super(message); }
}

class BookAlreadyIssuedException extends Exception {
    public BookAlreadyIssuedException(String message) { super(message); }
}

class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String message) { super(message); }
}

class InvalidIdException extends Exception {
    public InvalidIdException(String message) { super(message); }
}