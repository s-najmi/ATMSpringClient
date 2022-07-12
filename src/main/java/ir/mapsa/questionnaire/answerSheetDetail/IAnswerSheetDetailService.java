package ir.mapsa.questionnaire.answerSheetDetail;

import ir.mapsa.questionnaire.dto.AnswerSheetDetailDTO;

import java.util.Collection;

public interface IAnswerSheetDetailService {
    AnswerSheetDetailDTO save(AnswerSheetDetailDTO dto);
    AnswerSheetDetailDTO update(AnswerSheetDetailDTO dto);
    Collection<AnswerSheetDetailDTO> getALl();
    AnswerSheetDetailDTO getByID(Long id);
    void delete(Long id);
}
