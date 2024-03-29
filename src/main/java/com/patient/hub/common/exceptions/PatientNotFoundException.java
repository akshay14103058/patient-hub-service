package com.patient.hub.common.exceptions;

public class PatientNotFoundException extends Exception{
    private String errorCode;
    private String errorMessage;

    public PatientNotFoundException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
