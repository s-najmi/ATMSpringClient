package ir.mapsa.questionnaire.answerSheetItems;

import ir.mapsa.questionnaire.answerSheetDetail.IAnswerSheetDetailMapper;
import ir.mapsa.questionnaire.dto.AnswerSheetItem;
import ir.mapsa.questionnaire.dto.AnswerSheetItemDTO;
import ir.mapsa.questionnaire.questionItem.IQuestionItemMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IAnswerSheetDetailMapper.class, IQuestionItemMapper.class})
public interface IAnswerSheetItemMapper {
    AnswerSheetItem toEntity(AnswerSheetItemDTO dto);
    AnswerSheetItemDTO toDTO(AnswerSheetItem entity);
    List<AnswerSheetItemDTO> toDTOs(List<AnswerSheetItem> entities);
}
