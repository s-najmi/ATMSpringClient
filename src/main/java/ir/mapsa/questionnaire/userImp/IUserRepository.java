package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.User;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IGenericRepository<User, Long> {
}
