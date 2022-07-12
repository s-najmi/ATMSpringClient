package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {
    @ApiModelProperty(required = false)
    private long id;

    @ApiModelProperty(required = true, hidden = false)
    private String fullname;

    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = true, hidden = false)
    private String password;

    @ApiModelProperty(required = true, hidden = false)
    private UserType userType;
}
