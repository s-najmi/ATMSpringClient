package ir.mapsa.questionnaire.generic;

import ir.mapsa.questionnaire.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericService<T , D, PK> implements IGenericService<T , D, PK>{

    public abstract IGenericRepository getRepository();
    public abstract IGenericMapper getMapper();

    @Override
    public D save(D dto) {
        T entity = (T) getMapper().toEntity(dto);
        return (D) getMapper().toDTO(getRepository().save(entity));
    }

    @Override
    public D update(D dto) {
        T entity = (T) getMapper().toEntity(dto);
        return (D) getMapper().toDTO(getRepository().save(entity));
    }

    @Override
    public Collection<D> getALl() {
        Collection<D> result = getMapper().toDTOs((List) getRepository().findAll());
        return result;
    }

    @Override
    public D getByID(PK id) {
        Optional opt = getRepository().findById(id);
        if(opt.isEmpty()){
            throw new NotFoundException("Not Matched!");
        }
        return (D) getMapper().toDTO(opt.get());
    }

    @Override
    public void delete(PK id) {
        getByID(id);
        getRepository().deleteById(id);
    }
}
