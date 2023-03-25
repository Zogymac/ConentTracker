package controller;

import dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setDescription("Internal Server Error");
        errorResponse.setCode("500");
        errorResponse.setExceptionName(ex.getClass().getName());
        errorResponse.setExceptionMessage(ex.getMessage());
        errorResponse.setStacktrace(Arrays.asList(ex.getStackTrace()).stream()
                .map(StackTraceElement::toString)
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setDescription("Некорректные параметры запроса");
        errorResponse.setCode("400");
        errorResponse.setExceptionName(ex.getClass().getName());
        errorResponse.setExceptionMessage(ex.getMessage());
        errorResponse.setStacktrace(Arrays.asList(ex.getStackTrace()).stream()
                .map(StackTraceElement::toString)
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
