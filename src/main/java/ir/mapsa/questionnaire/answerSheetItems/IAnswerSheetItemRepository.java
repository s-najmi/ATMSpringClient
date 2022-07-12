package ir.mapsa.questionnaire.answerSheetItems;

import ir.mapsa.questionnaire.dto.AnswerSheetItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerSheetItemRepository extends PagingAndSortingRepository<AnswerSheetItem, Long> {
}
