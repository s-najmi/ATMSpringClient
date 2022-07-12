package ir.mapsa.questionnaire.questionnaireImp;

import ir.mapsa.questionnaire.dto.Questionnaire;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionnaireRepository extends IGenericRepository<Questionnaire, Long> {
}
