package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_questionnaie_detail")
public class QuestionnaireDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
