package ir.mapsa.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MyUserDTO {
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

    @ApiModelProperty(required = false, hidden = true)
    private String token;

    @ApiModelProperty(required = false, hidden = true)
    private Date tokenExpireTime;
}
