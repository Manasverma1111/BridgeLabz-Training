package org.example.contacts_app.exception;

public class ContactAlreadyExistsException
        extends RuntimeException {

    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}