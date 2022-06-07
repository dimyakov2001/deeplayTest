package main.java;

public class InvalidParamsException extends Error {
    public InvalidParamsException() {}

    public InvalidParamsException(String message) {
        super(message);
    }
}
