package ir.mapsa.questionnaire.security;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.userImp.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccessAPI {
    private final IUserService service;
    public Boolean findByToken(String token){
        Optional<MyUser> userOpt = service.findByToken(token.replace("Bearer ",""));
        if(userOpt.isEmpty())
            return false;
        MyUser user = userOpt.get();
        Date now = new Date(Calendar.getInstance().getTimeInMillis());
        if(user.getTokenExpireTime().compareTo(now) < 0) {
            service.makeToken(user);
            return true;
        }
        else{
            return true;
        }
    }
}
