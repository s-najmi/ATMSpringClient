package ir.mapsa.questionnaire.questionItem;


import ir.mapsa.questionnaire.dto.QuestionItem;
import ir.mapsa.questionnaire.dto.QuestionItemDTO;
import ir.mapsa.questionnaire.questionImp.IQuestionMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IQuestionMapper.class})
public interface IQuestionItemMapper {
    QuestionItem toEntity(QuestionItemDTO dto);
    QuestionItemDTO toDTO(QuestionItem entity);
    List<QuestionItemDTO> toDTOs(List<QuestionItem> entities);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void update(QuestionItemDTO questionItemDTO, @MappingTarget QuestionItem questionItem);
}
