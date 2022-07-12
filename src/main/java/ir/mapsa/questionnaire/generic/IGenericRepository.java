package ir.mapsa.questionnaire.generic;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface IGenericRepository<T, PK> extends PagingAndSortingRepository<T, PK> {
}
