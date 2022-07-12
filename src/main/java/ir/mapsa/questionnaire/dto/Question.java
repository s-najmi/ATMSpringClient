package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "question_type")
    private QuestionType questionType;

}
