package ir.mapsa.questionnaire.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_user")
public class MyUser {
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

    @Column(name = "token")
    private String token;

    @Column(name = "token_expire_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenExpireTime;
}
