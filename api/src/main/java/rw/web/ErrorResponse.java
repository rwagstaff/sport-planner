package rw.web;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class ErrorResponse  {

    private String message;
    private String callStack;


    public ErrorResponse() {
    }

    public ErrorResponse(String message, Throwable callStack) {
        this.message = message;
        this.callStack = ExceptionUtils.getStackTrace(callStack);
    }

    public String getMessage() {
        return message;
    }

    public String getCallStack() {
        return callStack;
    }
}
