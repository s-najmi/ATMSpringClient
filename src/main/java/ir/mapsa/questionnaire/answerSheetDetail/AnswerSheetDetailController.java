package ir.mapsa.questionnaire.answerSheetDetail;

import ir.mapsa.questionnaire.dto.AnswerSheetDetailDTO;
import ir.mapsa.questionnaire.dto.QuestionnaireDetailDTO;
import ir.mapsa.questionnaire.questionnaireDetail.IQuestionnaireDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answersheetdetail/v1")
@AllArgsConstructor
public class AnswerSheetDetailController {
    private final IAnswerSheetDetailService service;

    @GetMapping("/")
    public ResponseEntity<List<AnswerSheetDetailDTO>> getAllAnswerSheetDetails(){
        return new ResponseEntity<>((List<AnswerSheetDetailDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AnswerSheetDetailDTO> addNewAnswerSheetDetail(@RequestBody AnswerSheetDetailDTO answerSheetDetailDTO){
        return new ResponseEntity<>((AnswerSheetDetailDTO) service.save(answerSheetDetailDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<AnswerSheetDetailDTO> updateAnswerSheetDetail(@RequestBody AnswerSheetDetailDTO answerSheetDetailDTO){
        return new ResponseEntity<>(service.update(answerSheetDetailDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerSheetDetailDTO> getAnswerSheetDetailByID(@PathVariable Long id){
        return new ResponseEntity<>((AnswerSheetDetailDTO) service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswerSheetDetailByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
