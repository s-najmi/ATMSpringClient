package ir.mapsa.questionnaire.questionnaireDetail;

import ir.mapsa.questionnaire.dto.QuestionItemDTO;
import ir.mapsa.questionnaire.dto.QuestionnaireDetailDTO;
import ir.mapsa.questionnaire.questionItem.IQuestionItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnairedetail/v1")
@AllArgsConstructor
public class QuestionnaireDetailController {
    private final IQuestionnaireDetailService service;

    @GetMapping("/")
    public ResponseEntity<List<QuestionnaireDetailDTO>> getAllQuestionnaireDetail(){
        return new ResponseEntity<>((List<QuestionnaireDetailDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionnaireDetailDTO> addNewQuestionnaireDetail(@RequestBody QuestionnaireDetailDTO questionnaireDetailDTO){
        return new ResponseEntity<>((QuestionnaireDetailDTO) service.save(questionnaireDetailDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<QuestionnaireDetailDTO> updateQuestionnaireDetail(@RequestBody QuestionnaireDetailDTO questionnaireDetailDTO){
        return new ResponseEntity<>(service.update(questionnaireDetailDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionnaireDetailDTO> getQuestionnaireDetailByID(@PathVariable Long id){
        return new ResponseEntity<>((QuestionnaireDetailDTO) service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaireDetailByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
