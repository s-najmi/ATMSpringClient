package ir.mapsa.questionnaire.answerSheetDetail;

import ir.mapsa.questionnaire.dto.AnswerSheetDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerSheetDetailRepository extends PagingAndSortingRepository<AnswerSheetDetail, Long> {
}
