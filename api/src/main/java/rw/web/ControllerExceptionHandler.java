package rw.web;

import rw.error.AbstractBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler({AbstractBadRequestException.class, IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleError(HttpServletRequest req, AbstractBadRequestException exception) {
        // Default fallback for all unhandled exceptions
        logException(req, exception);
        return response(new ErrorResponse(exception.getMessage(), exception), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleError(HttpServletRequest req, Exception exception) {
        // Default fallback for all unhandled exceptions
        logException(req, exception);
        return response(new ErrorResponse("An unhandled error has occurred", exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> response(ErrorResponse errorResponse, HttpStatus status) {
        return new ResponseEntity<>(errorResponse, status);
    }

    private void logException(HttpServletRequest req, Exception e) {
        LOG.error("Error occurred for request {}", req.getRequestURI(), e);
    }

}
