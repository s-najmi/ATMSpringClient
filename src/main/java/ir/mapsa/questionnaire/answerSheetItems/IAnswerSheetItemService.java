package ir.mapsa.questionnaire.answerSheetItems;

import ir.mapsa.questionnaire.dto.AnswerSheetItemDTO;

import java.util.Collection;

public interface IAnswerSheetItemService {
    AnswerSheetItemDTO save(AnswerSheetItemDTO dto);
    AnswerSheetItemDTO update(AnswerSheetItemDTO dto);
    Collection<AnswerSheetItemDTO> getALl();
    AnswerSheetItemDTO getByID(Long id);
    void delete(Long id);
}
