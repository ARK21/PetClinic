package ru.ark.Clinic;

/**
 * Класс гененрируется при ошибке пользовательского ввода.
 */

public class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }
}
