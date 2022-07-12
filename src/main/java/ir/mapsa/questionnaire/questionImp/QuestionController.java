package ir.mapsa.questionnaire.questionImp;

import ir.mapsa.questionnaire.dto.QuestionDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question/v1")
@AllArgsConstructor
public class QuestionController {
    private final IQuestionService service;

    @GetMapping("/")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(){
        return new ResponseEntity<>((List<QuestionDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionDTO> addNewQuestion(@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>((QuestionDTO)service.save(questionDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>((QuestionDTO)service.save(questionDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionByID(@PathVariable Long id){
        return new ResponseEntity<>((QuestionDTO)service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
