package ir.mapsa.questionnaire.security;

import ir.mapsa.questionnaire.dto.MyUser;
import ir.mapsa.questionnaire.dto.MyUserLoginDTO;
import ir.mapsa.questionnaire.userImp.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private final IUserService service;

    @PostMapping("/")
    public String newToken(@RequestBody MyUserLoginDTO userLogin){
        Optional<MyUser> findUser = service.findByUserPass(userLogin.getNationalCode(), userLogin.getPassword());
        if (findUser.isEmpty())
            throw new RuntimeException("Not matched");
        return service.makeToken(findUser.get());
    }
}
