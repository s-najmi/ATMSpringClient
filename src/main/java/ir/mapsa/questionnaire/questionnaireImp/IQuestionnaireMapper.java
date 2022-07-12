package ir.mapsa.questionnaire.questionnaireImp;

import ir.mapsa.questionnaire.dto.Questionnaire;
import ir.mapsa.questionnaire.dto.QuestionnaireDTO;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IQuestionnaireMapper extends IGenericMapper<Questionnaire, QuestionnaireDTO> {
}
