package ir.mapsa.questionnaire.answerSheetDetail;

import ir.mapsa.questionnaire.dto.AnswerSheetDetail;
import ir.mapsa.questionnaire.dto.AnswerSheetDetailDTO;
import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.dto.QuestionnaireUserAuthDTO;
import ir.mapsa.questionnaire.exception.NotFoundException;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import ir.mapsa.questionnaire.questionnaireUserAuth.IQuestionnaireUserAuthMapper;
import ir.mapsa.questionnaire.questionnaireUserAuth.IQuestionnaireUserAuthService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerSheetDetailService implements IAnswerSheetDetailService {
    private final IAnswerSheetDetailRepository repository;
    private final IAnswerSheetDetailMapper mapper;
    private final IQuestionService questionService;
    private final IQuestionMapper questionMapper;
    private final IQuestionnaireUserAuthService questionnaireUserAuthService;
    private final IQuestionnaireUserAuthMapper questionnaireUserAuthMapper;

    public AnswerSheetDetailService(IAnswerSheetDetailRepository repository, IAnswerSheetDetailMapper mapper, IQuestionService questionService, IQuestionMapper questionMapper, IQuestionnaireUserAuthService questionnaireUserAuthService, IQuestionnaireUserAuthMapper questionnaireUserAuthMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.questionnaireUserAuthService = questionnaireUserAuthService;
        this.questionnaireUserAuthMapper = questionnaireUserAuthMapper;
    }

    @Override
    public AnswerSheetDetailDTO save(AnswerSheetDetailDTO dto) {
        AnswerSheetDetail answerSheetDetail = mapper.toEntity(dto);
        QuestionDTO questionDTO = questionService.getByID(answerSheetDetail.getQuestion().getId());
        QuestionnaireUserAuthDTO questionnaireUserAuthDTO = questionnaireUserAuthService.getByID(answerSheetDetail.getQuestionnaireUserAuth().getId());
        answerSheetDetail.setQuestion(questionMapper.toEntity(questionDTO));
        answerSheetDetail.setQuestionnaireUserAuth(questionnaireUserAuthMapper.toEntity(questionnaireUserAuthDTO));
        return mapper.toDTO(repository.save(answerSheetDetail));
    }

    @Override
    public AnswerSheetDetailDTO update(AnswerSheetDetailDTO dto) {
        AnswerSheetDetail answerSheetDetail = mapper.toEntity(dto);
        AnswerSheetDetail newAnswerSheetDetail = mapper.toEntity(getByID(answerSheetDetail.getId()));
        newAnswerSheetDetail.setQuestion(questionMapper.toEntity(questionService.getByID((Long)answerSheetDetail.getQuestion().getId())));
        newAnswerSheetDetail.setQuestionnaireUserAuth(questionnaireUserAuthMapper.toEntity(questionnaireUserAuthService.getByID((Long)answerSheetDetail.getQuestionnaireUserAuth().getId())));
        newAnswerSheetDetail.setResponseString(answerSheetDetail.getResponseString());
        newAnswerSheetDetail.setResponseNum1(answerSheetDetail.getResponseNum1());
        newAnswerSheetDetail.setResponseNum2(answerSheetDetail.getResponseNum2());
        return mapper.toDTO(repository.save(newAnswerSheetDetail));
    }

    @Override
    public Collection<AnswerSheetDetailDTO> getALl() {
        return mapper.toDTOs((List<AnswerSheetDetail>) repository.findAll());
    }

    @Override
    public AnswerSheetDetailDTO getByID(Long id) {
        Optional opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("Not Matched!");
        }
        return mapper.toDTO((AnswerSheetDetail) opt.get());
    }

    @Override
    public void delete(Long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
