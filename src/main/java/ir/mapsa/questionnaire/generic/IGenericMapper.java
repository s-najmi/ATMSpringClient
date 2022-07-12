package ir.mapsa.questionnaire.generic;

import ir.mapsa.questionnaire.dto.QuestionDTO;
import ir.mapsa.questionnaire.dto.QuestionItem;
import ir.mapsa.questionnaire.dto.QuestionItemDTO;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface IGenericMapper<T, D>{
    T toEntity(D dto);
    D toDTO(T entity);
    List<D> toDTOs(List<T> entities);
}
