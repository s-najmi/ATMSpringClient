package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IGenericRepository<MyUser, Long> {
    Optional<MyUser> findByNationalCodeAndPassword(String nationalCode, String password);
    Optional<MyUser> findByToken(String token);
}
