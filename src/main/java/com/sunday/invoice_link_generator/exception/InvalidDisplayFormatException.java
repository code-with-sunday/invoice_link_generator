package com.sunday.invoice_link_generator.exception;

public class InvalidDisplayFormatException extends Exception{

    private static final long serialVersionUID = -4863069884591857487L;

    public InvalidDisplayFormatException(String message){
        super(message);
    }

    public InvalidDisplayFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
