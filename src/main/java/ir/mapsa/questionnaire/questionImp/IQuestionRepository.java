package ir.mapsa.questionnaire.questionImp;

import ir.mapsa.questionnaire.dto.Question;
import ir.mapsa.questionnaire.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends IGenericRepository<Question, Long> {
}
