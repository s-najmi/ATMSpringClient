package ir.mapsa.questionnaire.questionItem;

import ir.mapsa.questionnaire.dto.Question;
import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.dto.QuestionItem;
import ir.mapsa.questionnaire.dto.QuestionItemDTO;
import ir.mapsa.questionnaire.exception.NotFoundException;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionItemService implements IQuestionItemService {
    private final IQuestionItemRepository repository;
    private final IQuestionItemMapper mapper;
    private final IQuestionService questionService;
    private final IQuestionMapper questionMapper;

    public QuestionItemService(IQuestionItemRepository repository, IQuestionItemMapper mapper, IQuestionService questionService, IQuestionMapper questionMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @Override
    public QuestionItemDTO save(QuestionItemDTO dto) {
        QuestionItem questionItem = mapper.toEntity(dto);
        QuestionDTO questionDTO = questionService.getByID(questionItem.getQuestion().getId());
        questionItem.setQuestion(questionMapper.toEntity(questionDTO));
        return mapper.toDTO(repository.save(questionItem));
    }

    @Override
    public QuestionItemDTO update(QuestionItemDTO dto) {
        QuestionItem questionItem = mapper.toEntity(dto);
        QuestionItem newQuestionItem = mapper.toEntity(getByID(questionItem.getId()));
        newQuestionItem.setQuestion(questionMapper.toEntity(questionService.getByID((Long)questionItem.getQuestion().getId())));
        newQuestionItem.setTitle(questionItem.getTitle());
        return mapper.toDTO(repository.save(newQuestionItem));
    }

    @Override
    public Collection<QuestionItemDTO> getALl() {
        return mapper.toDTOs((List<QuestionItem>) repository.findAll());
    }

    @Override
    public QuestionItemDTO getByID(Long id) {
        Optional opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("Not Matched!");
        }
        return mapper.toDTO((QuestionItem) opt.get());
    }

    @Override
    public void delete(Long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
