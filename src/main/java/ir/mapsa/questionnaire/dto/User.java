package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "nationalcode")
    private String nationalCode;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "user_type")
    private UserType userType;

}
