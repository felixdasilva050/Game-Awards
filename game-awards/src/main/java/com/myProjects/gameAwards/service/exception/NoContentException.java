package com.myProjects.gameAwards.service.exception;

public class NoContentException extends RuntimeException{
    private static final long SERIAL_VERSION_UID = 1L;
    public NoContentException(String message) {
        super(message);
    }
}
