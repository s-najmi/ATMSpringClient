package ir.mapsa.questionnaire.questionItem;

import ir.mapsa.questionnaire.dto.QuestionItemDTO;
import ir.mapsa.questionnaire.security.AccessAPI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionitem/v1")
@AllArgsConstructor
public class QuestionItemController {
    private final IQuestionItemService service;
    private final AccessAPI accessAPI;

    @GetMapping("/")
    public ResponseEntity<List<QuestionItemDTO>> getAllQuestionItems(){
        return new ResponseEntity<>((List<QuestionItemDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionItemDTO> addNewQuestion(@RequestBody QuestionItemDTO questionItemDTO,
                                                          @RequestHeader("Authorization") String token){
        if(accessAPI.findByToken(token) == false){
            throw new RuntimeException("Not access");
        }
        return new ResponseEntity<>((QuestionItemDTO) service.save(questionItemDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<QuestionItemDTO> updateQuestion(@RequestBody QuestionItemDTO questionDTO){
        return new ResponseEntity<>(service.update(questionDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionItemDTO> getQuestionByID(@PathVariable Long id){
        return new ResponseEntity<>((QuestionItemDTO)service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
