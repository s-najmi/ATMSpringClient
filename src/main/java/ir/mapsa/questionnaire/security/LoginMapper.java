package ir.mapsa.questionnaire.security;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.dto.MyUserLoginDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    MyUserLoginDTO toLoginData(MyUser user);
}
