package ir.mapsa.questionnaire.questionImp;

import ir.mapsa.questionnaire.dto.Question;
import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.generic.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IQuestionMapper extends IGenericMapper<Question, QuestionDTO> {
}
