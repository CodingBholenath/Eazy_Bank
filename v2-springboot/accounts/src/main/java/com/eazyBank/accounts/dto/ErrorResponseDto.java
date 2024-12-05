package com.eazyBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Schema(
        name="ErrorResponse",
        description="Error Response"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {
@Schema(
        description = "API path invoked by client"
)
private String apiPath;
@Schema(
        description = "Error Code representing the error happened in the API"
)
private HttpStatus errorCode;
@Schema(
        description = "Error message representing the error happened in the API"
)
private String errorMessage;
@Schema(
        description = "Time when the error happened in the API"
)
private LocalDateTime errorTime;
}
