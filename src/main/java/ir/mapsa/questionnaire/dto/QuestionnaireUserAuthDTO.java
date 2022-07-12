package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuestionnaireUserAuthDTO {
    @ApiModelProperty(required = false)
    private long id;

    @ApiModelProperty(required = true, hidden = false)
    private QuestionnaireDTO questionnaire;

    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;
}
