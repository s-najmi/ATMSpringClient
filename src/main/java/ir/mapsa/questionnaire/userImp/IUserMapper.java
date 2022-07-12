package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.User;
import ir.mapsa.questionnaire.dto.UserDTO;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<User, UserDTO> {
}
