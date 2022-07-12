package ir.mapsa.questionnaire.questionnaireDetail;

import ir.mapsa.questionnaire.dto.QuestionnaireDetail;
import ir.mapsa.questionnaire.dto.QuestionnaireDetailDTO;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IQuestionMapper.class, IQuestionnaireMapper.class})
public interface IQuestionnaireDetailMapper {
    QuestionnaireDetail toEntity(QuestionnaireDetailDTO dto);
    QuestionnaireDetailDTO toDTO(QuestionnaireDetail entity);
    List<QuestionnaireDetailDTO> toDTOs(List<QuestionnaireDetail> entities);
}
