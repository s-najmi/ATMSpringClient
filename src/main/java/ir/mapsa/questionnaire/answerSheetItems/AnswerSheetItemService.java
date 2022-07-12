package ir.mapsa.questionnaire.answerSheetItems;

import ir.mapsa.questionnaire.answerSheetDetail.IAnswerSheetDetailMapper;
import ir.mapsa.questionnaire.answerSheetDetail.IAnswerSheetDetailRepository;
import ir.mapsa.questionnaire.answerSheetDetail.IAnswerSheetDetailService;
import ir.mapsa.questionnaire.dto.*;
import ir.mapsa.questionnaire.exception.NotFoundException;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import ir.mapsa.questionnaire.questionItem.IQuestionItemMapper;
import ir.mapsa.questionnaire.questionItem.IQuestionItemService;
import ir.mapsa.questionnaire.questionnaireUserAuth.IQuestionnaireUserAuthMapper;
import ir.mapsa.questionnaire.questionnaireUserAuth.IQuestionnaireUserAuthService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerSheetItemService implements IAnswerSheetItemService {
    private final IAnswerSheetItemRepository repository;
    private final IAnswerSheetItemMapper mapper;
    private final IQuestionItemService questionItemService;
    private final IQuestionItemMapper questionItemMapper;
    private final IAnswerSheetDetailService answerSheetDetailService;
    private final IAnswerSheetDetailMapper answerSheetDetailMapper;

    public AnswerSheetItemService(IAnswerSheetItemRepository repository, IAnswerSheetItemMapper mapper, IQuestionItemService questionItemService, IQuestionItemMapper questionItemMapper, IAnswerSheetDetailService answerSheetDetailService, IAnswerSheetDetailMapper answerSheetDetailMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.questionItemService = questionItemService;
        this.questionItemMapper = questionItemMapper;
        this.answerSheetDetailService = answerSheetDetailService;
        this.answerSheetDetailMapper = answerSheetDetailMapper;
    }

    @Override
    public AnswerSheetItemDTO save(AnswerSheetItemDTO dto) {
        AnswerSheetItem answerSheetItem = mapper.toEntity(dto);
        QuestionItemDTO questionItemDTO = questionItemService.getByID(answerSheetItem.getQuestionItem().getId());
        AnswerSheetDetailDTO answerSheetDetailDTO = answerSheetDetailService.getByID(answerSheetItem.getAnswerSheetDetail().getId());
        answerSheetItem.setQuestionItem(questionItemMapper.toEntity(questionItemDTO));
        answerSheetItem.setAnswerSheetDetail(answerSheetDetailMapper.toEntity(answerSheetDetailDTO));
        return mapper.toDTO(repository.save(answerSheetItem));
    }

    @Override
    public AnswerSheetItemDTO update(AnswerSheetItemDTO dto) {
        AnswerSheetItem answerSheetItem = mapper.toEntity(dto);
        AnswerSheetItem newAnswerSheetItem = mapper.toEntity(getByID(answerSheetItem.getId()));
        newAnswerSheetItem.setQuestionItem(questionItemMapper.toEntity(questionItemService.getByID((Long)answerSheetItem.getQuestionItem().getId())));
        newAnswerSheetItem.setAnswerSheetDetail(answerSheetDetailMapper.toEntity(answerSheetDetailService.getByID((Long)answerSheetItem.getAnswerSheetDetail().getId())));
        return mapper.toDTO(repository.save(newAnswerSheetItem));
    }

    @Override
    public Collection<AnswerSheetItemDTO> getALl() {
        return mapper.toDTOs((List<AnswerSheetItem>) repository.findAll());
    }

    @Override
    public AnswerSheetItemDTO getByID(Long id) {
        Optional opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("Not Matched!");
        }
        return mapper.toDTO((AnswerSheetItem) opt.get());
    }

    @Override
    public void delete(Long id) {
        getByID(id);
        repository.deleteById(id);
    }
}
