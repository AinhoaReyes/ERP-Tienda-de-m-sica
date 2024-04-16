package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import grupoB.erp.domain.Task;

@Repository
public interface TaskDAO extends CrudRepository<Task, Long> {
    Task findByName(String name);
}
