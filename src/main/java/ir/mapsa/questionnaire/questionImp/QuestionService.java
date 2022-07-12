package ir.mapsa.questionnaire.questionImp;

import ir.mapsa.questionnaire.dto.Question;
import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.generic.GenericService;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends GenericService<Question, QuestionDTO, Long>
        implements IQuestionService {

    private final IQuestionRepository repository;
    private final IQuestionMapper mapper;

    public QuestionService(IQuestionRepository repository, IQuestionMapper mapper) {
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
