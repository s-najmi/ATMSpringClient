package ir.mapsa.questionnaire.questionnaireDetail;

import ir.mapsa.questionnaire.dto.*;
import ir.mapsa.questionnaire.exception.NotFoundException;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import ir.mapsa.questionnaire.questionItem.IQuestionItemMapper;
import ir.mapsa.questionnaire.questionItem.IQuestionItemRepository;
import ir.mapsa.questionnaire.questionItem.IQuestionItemService;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireMapper;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireDetailService implements IQuestionnaireDetailService {
    private final IQuestionnaireDetailRepository repository;
    private final IQuestionnaireDetailMapper mapper;
    private final IQuestionService questionService;
    private final IQuestionMapper questionMapper;
    private final IQuestionnaireService questionnaireService;
    private final IQuestionnaireMapper questionnaireMapper;

    public QuestionnaireDetailService(IQuestionnaireDetailRepository repository, IQuestionnaireDetailMapper mapper, IQuestionService questionService, IQuestionMapper questionMapper, IQuestionnaireService questionnaireService, IQuestionnaireMapper questionnaireMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.questionnaireService = questionnaireService;
        this.questionnaireMapper = questionnaireMapper;
    }

    @Override
    public QuestionnaireDetailDTO save(QuestionnaireDetailDTO dto) {
        QuestionnaireDetail questionnaireDetail = mapper.toEntity(dto);
        QuestionDTO questionDTO = questionService.getByID(questionnaireDetail.getQuestion().getId());
        QuestionnaireDTO questionnaireDTO = questionnaireService.getByID(questionnaireDetail.getQuestionnaire().getId());
        questionnaireDetail.setQuestion(questionMapper.toEntity(questionDTO));
        questionnaireDetail.setQuestionnaire(questionnaireMapper.toEntity(questionnaireDTO));
        return mapper.toDTO(repository.save(questionnaireDetail));
    }

    @Override
    public QuestionnaireDetailDTO update(QuestionnaireDetailDTO dto) {
        QuestionnaireDetail questionnaireDetail = mapper.toEntity(dto);
        QuestionnaireDetail newQuestionnaireDetail = mapper.toEntity(getByID(questionnaireDetail.getId()));
        newQuestionnaireDetail.setQuestion(questionMapper.toEntity(questionService.getByID((Long)questionnaireDetail.getQuestion().getId())));
        newQuestionnaireDetail.setQuestionnaire(questionnaireMapper.toEntity(questionnaireService.getByID((Long)questionnaireDetail.getQuestionnaire().getId())));
        return mapper.toDTO(repository.save(newQuestionnaireDetail));
    }

    @Override
    public Collection<QuestionnaireDetailDTO> getALl() {
        return mapper.toDTOs((List<QuestionnaireDetail>) repository.findAll());
    }

    @Override
    public QuestionnaireDetailDTO getByID(Long id) {
        Optional opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("Not Matched!");
        }
        return mapper.toDTO((QuestionnaireDetail) opt.get());
    }

    @Override
    public void delete(Long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
