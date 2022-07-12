package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Data
public class QuestionItemDTO {
    @ApiModelProperty(required = false)
    private long id;

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private QuestionDTO question;
}
