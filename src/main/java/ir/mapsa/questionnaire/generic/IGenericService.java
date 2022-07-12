package ir.mapsa.questionnaire.generic;

import java.util.Collection;

public interface IGenericService<T, D, PK> {
    D save(D dto);
    D update(D dto);
    Collection<D> getALl();
    D getByID(PK id);
    void delete(PK id);
}
