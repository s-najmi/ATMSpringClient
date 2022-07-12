package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.dto.UserDTO;
import ir.mapsa.questionnaire.questionImp.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1")
@AllArgsConstructor
public class UserController {
    private final IUserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>((List<UserDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>((UserDTO)service.save(userDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>((UserDTO)service.save(userDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Long id){
        return new ResponseEntity<>((UserDTO)service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
