package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_answersheet_items")
public class AnswerSheetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "answersheet_detail_id")
    private AnswerSheetDetail answerSheetDetail ;

    @ManyToOne
    @JoinColumn(name = "question_item_id")
    private QuestionItem questionItem;
}
