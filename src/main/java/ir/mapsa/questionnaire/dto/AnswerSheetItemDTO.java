package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnswerSheetItemDTO {
    @ApiModelProperty(required = false)
    private long id;

    @ApiModelProperty(required = true, hidden = false)
    private AnswerSheetDetailDTO answerSheetDetail ;

    @ApiModelProperty(required = true, hidden = false)
    private QuestionItemDTO questionItem;
}
