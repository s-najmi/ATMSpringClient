package ir.mapsa.questionnaire.questionnaireUserAuth;

import ir.mapsa.questionnaire.dto.*;
import ir.mapsa.questionnaire.exception.NotFoundException;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireMapper;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireService;
import ir.mapsa.questionnaire.userImp.IUserMapper;
import ir.mapsa.questionnaire.userImp.IUserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireUserAuthService implements IQuestionnaireUserAuthService {
    private final IQuestionnaireUserAuthRepository repository;
    private final IQuestionnaireUserAuthMapper mapper;
    private final IUserService userService;
    private final IUserMapper userMapper;
    private final IQuestionnaireService questionnaireService;
    private final IQuestionnaireMapper questionnaireMapper;

    public QuestionnaireUserAuthService(IQuestionnaireUserAuthRepository repository, IQuestionnaireUserAuthMapper mapper, IUserService userService, IUserMapper userMapper, IQuestionnaireService questionnaireService, IQuestionnaireMapper questionnaireMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.questionnaireService = questionnaireService;
        this.questionnaireMapper = questionnaireMapper;
    }

    @Override
    public QuestionnaireUserAuthDTO save(QuestionnaireUserAuthDTO dto) {
        QuestionnaireUserAuth questionnaireUserAuth = mapper.toEntity(dto);
        MyUserDTO myUserDTO = userService.getByID(questionnaireUserAuth.getMyUser().getId());
        QuestionnaireDTO questionnaireDTO = questionnaireService.getByID(questionnaireUserAuth.getQuestionnaire().getId());
        questionnaireUserAuth.setMyUser(userMapper.toEntity(myUserDTO));
        questionnaireUserAuth.setQuestionnaire(questionnaireMapper.toEntity(questionnaireDTO));
        return mapper.toDTO(repository.save(questionnaireUserAuth));
    }

    @Override
    public QuestionnaireUserAuthDTO update(QuestionnaireUserAuthDTO dto) {
        QuestionnaireUserAuth questionnaireUserAuth = mapper.toEntity(dto);
        QuestionnaireUserAuth newQuestionnaireUserAuth = mapper.toEntity(getByID(questionnaireUserAuth.getId()));
        newQuestionnaireUserAuth.setMyUser(userMapper.toEntity(userService.getByID((Long)questionnaireUserAuth.getMyUser().getId())));
        newQuestionnaireUserAuth.setQuestionnaire(questionnaireMapper.toEntity(questionnaireService.getByID((Long)questionnaireUserAuth.getQuestionnaire().getId())));
        return mapper.toDTO(repository.save(newQuestionnaireUserAuth));
    }

    @Override
    public Collection<QuestionnaireUserAuthDTO> getALl() {
        return mapper.toDTOs((List<QuestionnaireUserAuth>) repository.findAll());
    }

    @Override
    public QuestionnaireUserAuthDTO getByID(Long id) {
        Optional opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("Not Matched!");
        }
        return mapper.toDTO((QuestionnaireUserAuth) opt.get());
    }

    @Override
    public void delete(Long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
