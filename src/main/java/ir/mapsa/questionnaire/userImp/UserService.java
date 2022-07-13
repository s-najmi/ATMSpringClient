package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.dto.MyUserDTO;
import ir.mapsa.questionnaire.generic.GenericService;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class UserService extends GenericService<MyUser, MyUserDTO, Long>
        implements IUserService {

    private final IUserRepository repository;
    private final IUserMapper mapper;

    public UserService(IUserRepository repository, IUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public IGenericRepository getRepository() {
        return repository;
    }

    @Override
    public IGenericMapper getMapper() {
        return mapper;
    }

    @Override
    public String makeToken(MyUser user) {
        UUID token = UUID.randomUUID();
        String myToken = String.valueOf(token);
        user.setToken(myToken);
        user.setTokenExpireTime(new Date(Calendar.getInstance().getTimeInMillis() + (10 * 60 * 1000)));
        repository.save(user);
        return myToken;
    }

    @Override
    public Optional<MyUser> findByUserPass(String userName, String password) {
        Optional<MyUser> authUser = repository.findByNationalCodeAndPassword(userName,password);
        if (authUser.isEmpty())
                return Optional.empty();
        return authUser;
    }

    @Override
    public Optional<MyUser> findByToken(String token) {
        Optional<MyUser> user = repository.findByToken(token);
        return user;
    }
}
