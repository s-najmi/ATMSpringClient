package ir.mapsa.questionnaire.answerSheetItems;

import ir.mapsa.questionnaire.answerSheetDetail.IAnswerSheetDetailService;
import ir.mapsa.questionnaire.dto.AnswerSheetDetailDTO;
import ir.mapsa.questionnaire.dto.AnswerSheetItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answersheetitem/v1")
@AllArgsConstructor
public class AnswerSheetItemController {
    private final IAnswerSheetItemService service;

    @GetMapping("/")
    public ResponseEntity<List<AnswerSheetItemDTO>> getAllAnswerSheetitems(){
        return new ResponseEntity<>((List<AnswerSheetItemDTO>) service.getALl(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AnswerSheetItemDTO> addNewAnswerSheetItem(@RequestBody AnswerSheetItemDTO answerSheetItemDTO){
        return new ResponseEntity<>((AnswerSheetItemDTO) service.save(answerSheetItemDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<AnswerSheetItemDTO> updateAnswerSheetItem(@RequestBody AnswerSheetItemDTO answerSheetItemDTO){
        return new ResponseEntity<>(service.update(answerSheetItemDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerSheetItemDTO> getAnswerSheetItemByID(@PathVariable Long id){
        return new ResponseEntity<>((AnswerSheetItemDTO) service.getByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswerSheetItemByID(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
