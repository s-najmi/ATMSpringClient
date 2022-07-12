package ir.mapsa.questionnaire.questionItem;

import ir.mapsa.questionnaire.dto.QuestionItem;
import ir.mapsa.questionnaire.dto.QuestionItemDTO;

import java.util.Collection;

public interface IQuestionItemService {
    QuestionItemDTO save(QuestionItemDTO dto);
    QuestionItemDTO update(QuestionItemDTO dto);
    Collection<QuestionItemDTO> getALl();
    QuestionItemDTO getByID(Long id);
    void delete(Long id);
}
