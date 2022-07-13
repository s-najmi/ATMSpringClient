package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.dto.MyUserDTO;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<MyUser, MyUserDTO> {
}
