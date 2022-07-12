package ir.mapsa.questionnaire.questionItem;

import ir.mapsa.questionnaire.dto.QuestionItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionItemRepository extends PagingAndSortingRepository<QuestionItem, Long> {
}
