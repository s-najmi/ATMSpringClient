package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnswerSheetDetailDTO {
    @ApiModelProperty(required = false)
    private long id;

    @ApiModelProperty(required = true, hidden = false)
    private QuestionnaireUserAuthDTO questionnaireUserAuth ;

    @ApiModelProperty(required = true, hidden = false)
    private QuestionDTO question;

    @ApiModelProperty(required = true, hidden = false)
    private String responseString;

    @ApiModelProperty(required = true, hidden = false)
    private Number responseNum1;

    @ApiModelProperty(required = true, hidden = false)
    private Number responseNum2;
}
