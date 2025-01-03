package huyvu.exception;

import huyvu.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse> AppException(final AppException e) {


        return ResponseEntity.status(e.getResponseCode().getStatus()).body(new ApiResponse(e.getResponseCode()));
    }
}
