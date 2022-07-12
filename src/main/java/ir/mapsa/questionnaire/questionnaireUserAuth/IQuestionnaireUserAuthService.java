package ir.mapsa.questionnaire.questionnaireUserAuth;

import ir.mapsa.questionnaire.dto.QuestionnaireUserAuthDTO;

import java.util.Collection;

public interface IQuestionnaireUserAuthService {
    QuestionnaireUserAuthDTO save(QuestionnaireUserAuthDTO dto);
    QuestionnaireUserAuthDTO update(QuestionnaireUserAuthDTO dto);
    Collection<QuestionnaireUserAuthDTO> getALl();
    QuestionnaireUserAuthDTO getByID(Long id);
    void delete(Long id);
}
