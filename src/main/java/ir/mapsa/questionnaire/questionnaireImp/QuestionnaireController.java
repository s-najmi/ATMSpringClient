package ir.mapsa.questionnaire.questionnaireImp;

import ir.mapsa.questionnaire.dto.QuestionnaireDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire/v1")
@AllArgsConstructor
public class QuestionnaireController {
    private final IQuestionnaireService service;

    @GetMapping("/")
    public ResponseEntity<List<QuestionnaireDTO>> getAllQuestionnaires(){
        return new ResponseEntity<>((List<QuestionnaireDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionnaireDTO> addNewQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO){
        return new ResponseEntity<>((QuestionnaireDTO)service.save(questionnaireDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<QuestionnaireDTO> updateQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO){
        return new ResponseEntity<>((QuestionnaireDTO)service.save(questionnaireDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionnaireDTO> getQuestionnaireByID(@PathVariable Long id){
        return new ResponseEntity<>((QuestionnaireDTO)service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaireByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
