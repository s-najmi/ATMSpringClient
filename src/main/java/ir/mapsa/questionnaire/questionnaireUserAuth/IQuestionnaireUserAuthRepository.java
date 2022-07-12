package ir.mapsa.questionnaire.questionnaireUserAuth;

import ir.mapsa.questionnaire.dto.QuestionnaireUserAuth;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionnaireUserAuthRepository extends PagingAndSortingRepository<QuestionnaireUserAuth, Long> {
}
