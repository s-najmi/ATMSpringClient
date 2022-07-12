package ir.mapsa.questionnaire.questionnaireUserAuth;

import ir.mapsa.questionnaire.dto.QuestionnaireUserAuth;
import ir.mapsa.questionnaire.dto.QuestionnaireUserAuthDTO;
import ir.mapsa.questionnaire.questionnaireImp.IQuestionnaireMapper;
import ir.mapsa.questionnaire.userImp.IUserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IUserMapper.class, IQuestionnaireMapper.class})
public interface IQuestionnaireUserAuthMapper {
    QuestionnaireUserAuth toEntity(QuestionnaireUserAuthDTO dto);
    QuestionnaireUserAuthDTO toDTO(QuestionnaireUserAuth entity);
    List<QuestionnaireUserAuthDTO> toDTOs(List<QuestionnaireUserAuth> entities);
}
