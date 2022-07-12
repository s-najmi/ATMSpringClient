package ir.mapsa.questionnaire.questionnaireUserAuth;

import ir.mapsa.questionnaire.dto.QuestionnaireDetailDTO;
import ir.mapsa.questionnaire.dto.QuestionnaireUserAuthDTO;
import ir.mapsa.questionnaire.questionnaireDetail.IQuestionnaireDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaireuser/v1")
@AllArgsConstructor
public class QuestionnaireUserAuthController {
    private final IQuestionnaireUserAuthService service;

    @GetMapping("/")
    public ResponseEntity<List<QuestionnaireUserAuthDTO>> getAllQuestionnaireUserAuth(){
        return new ResponseEntity<>((List<QuestionnaireUserAuthDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionnaireUserAuthDTO> addNewQuestionnaireUserAuth(@RequestBody QuestionnaireUserAuthDTO questionnaireUserAuthDTO){
        return new ResponseEntity<>((QuestionnaireUserAuthDTO) service.save(questionnaireUserAuthDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<QuestionnaireUserAuthDTO> updateQuestionnaireUserAuth(@RequestBody QuestionnaireUserAuthDTO questionnaireUserAuthDTO){
        return new ResponseEntity<>(service.update(questionnaireUserAuthDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionnaireUserAuthDTO> getQuestionnaireUserAuthByID(@PathVariable Long id){
        return new ResponseEntity<>((QuestionnaireUserAuthDTO) service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaireUserAuthByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
