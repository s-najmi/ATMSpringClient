package ir.mapsa.questionnaire.answerSheetDetail;

import ir.mapsa.questionnaire.dto.AnswerSheetDetail;
import ir.mapsa.questionnaire.dto.AnswerSheetDetailDTO;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionnaireUserAuth.IQuestionnaireUserAuthMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IQuestionMapper.class, IQuestionnaireUserAuthMapper.class})
public interface IAnswerSheetDetailMapper {
    AnswerSheetDetail toEntity(AnswerSheetDetailDTO dto);
    AnswerSheetDetailDTO toDTO(AnswerSheetDetail entity);
    List<AnswerSheetDetailDTO> toDTOs(List<AnswerSheetDetail> entities);
}
