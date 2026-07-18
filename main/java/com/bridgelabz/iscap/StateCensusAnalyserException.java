package com.bridgelabz.iscap;

/**
 * Custom exception class for State Census Analyser.
 */
public class StateCensusAnalyserException extends Exception {

    /**
     * Enum representing different exception types.
     */
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        CENSUS_FILE_TYPE_INCORRECT
    }

    public ExceptionType type;

    /**
     * Constructor to initialize exception message and type.
     *
     * @param message Exception message
     * @param type    Type of exception
     */
    public StateCensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}