package ir.mapsa.questionnaire.questionnaireDetail;

import ir.mapsa.questionnaire.dto.QuestionnaireDetailDTO;

import java.util.Collection;

public interface IQuestionnaireDetailService {
    QuestionnaireDetailDTO save(QuestionnaireDetailDTO dto);
    QuestionnaireDetailDTO update(QuestionnaireDetailDTO dto);
    Collection<QuestionnaireDetailDTO> getALl();
    QuestionnaireDetailDTO getByID(Long id);
    void delete(Long id);
}
