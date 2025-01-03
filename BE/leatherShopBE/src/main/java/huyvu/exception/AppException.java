package huyvu.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class AppException extends RuntimeException{
    private ResponseCode responseCode;
}
