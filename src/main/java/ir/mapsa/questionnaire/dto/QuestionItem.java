package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_question_item")
public class QuestionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
