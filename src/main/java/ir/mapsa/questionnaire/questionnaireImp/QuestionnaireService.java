package ir.mapsa.questionnaire.questionnaireImp;

import ir.mapsa.questionnaire.dto.Question;
import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.dto.Questionnaire;
import ir.mapsa.questionnaire.dto.QuestionnaireDTO;
import ir.mapsa.questionnaire.generic.GenericService;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionImp.IQuestionRepository;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService extends GenericService<Questionnaire, QuestionnaireDTO, Long>
        implements IQuestionnaireService {

    private final IQuestionnaireRepository repository;
    private final IQuestionnaireMapper mapper;

    public QuestionnaireService(IQuestionnaireRepository repository, IQuestionnaireMapper mapper) {
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
