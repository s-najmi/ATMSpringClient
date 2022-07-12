package ir.mapsa.questionnaire.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiEr {
    private String message;
    private HttpStatus status;
}
