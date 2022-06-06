package main.java.math;

/**
 * Класс ошибки неправильной размерности тензоров
 */
public class InvalidShapeException extends Error {
    public InvalidShapeException() {}

    public InvalidShapeException(String message) {
        super(message);
    }
}
