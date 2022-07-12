package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_answersheet_detail")
public class AnswerSheetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "questionnaire_user_id")
    private QuestionnaireUserAuth questionnaireUserAuth ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "response_string")
    private String responseString;

    @Column(name = "response_number1")
    private Number responseNum1;

    @Column(name = "response_number2")
    private Number responseNum2;
}
