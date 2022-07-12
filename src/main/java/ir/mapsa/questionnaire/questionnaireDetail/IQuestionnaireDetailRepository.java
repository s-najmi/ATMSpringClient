package ir.mapsa.questionnaire.questionnaireDetail;

import ir.mapsa.questionnaire.dto.QuestionnaireDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionnaireDetailRepository extends PagingAndSortingRepository<QuestionnaireDetail, Long> {
}
