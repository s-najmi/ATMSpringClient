package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.dto.MyUserDTO;
import ir.mapsa.questionnaire.generic.IGenericService;

import java.util.Date;
import java.util.Optional;

public interface IUserService extends IGenericService<MyUser, MyUserDTO, Long> {
    String makeToken(MyUser user);
    Optional<MyUser> findByUserPass(String userName, String password);
    Optional<MyUser> findByToken(String token);
}
