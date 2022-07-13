package ir.mapsa.questionnaire.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, PK> extends JpaRepository<T, PK> {
}
