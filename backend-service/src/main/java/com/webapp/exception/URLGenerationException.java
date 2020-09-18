package com.webapp.exception;

public class URLGenerationException extends RuntimeException{

    public URLGenerationException(String message){super(message);}

    public URLGenerationException(String message, Throwable cause){super(message, cause);}

}
