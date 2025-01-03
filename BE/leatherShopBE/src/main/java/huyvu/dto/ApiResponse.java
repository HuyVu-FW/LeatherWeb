package huyvu.dto;

import ch.qos.logback.core.spi.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonInclude;
import huyvu.exception.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code;
    private HttpStatus status;
    private String message;
    private T result;

    public ApiResponse(ResponseCode responseCode, T result) {
        this.status = responseCode.getStatus();
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.result = result;
    }
    public ApiResponse(ResponseCode responseCode) {
        this.status = responseCode.getStatus();
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();

    }
}
