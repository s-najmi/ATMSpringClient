package ir.mapsa.questionnaire.userImp;

import ir.mapsa.questionnaire.dto.MyUserDTO;
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
    public ResponseEntity<List<MyUserDTO>> getAllUsers(){
        return new ResponseEntity<>((List<MyUserDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<MyUserDTO> addNewUser(@RequestBody MyUserDTO myUserDTO){
        return new ResponseEntity<>((MyUserDTO)service.save(myUserDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<MyUserDTO> updateUser(@RequestBody MyUserDTO myUserDTO){
        return new ResponseEntity<>((MyUserDTO)service.save(myUserDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyUserDTO> getUserByID(@PathVariable Long id){
        return new ResponseEntity<>((MyUserDTO)service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
