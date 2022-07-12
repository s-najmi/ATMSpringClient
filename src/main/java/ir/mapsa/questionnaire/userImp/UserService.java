package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.User;
import ir.mapsa.questionnaire.dto.UserDTO;
import ir.mapsa.questionnaire.generic.GenericService;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, UserDTO, Long>
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
}
