package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import grupoB.erp.domain.Task;

@Repository
public interface TaskDAO extends CrudRepository<Task, Long> {

    //Método para buscar una tarea por su nombre de usuario y contrase
    Task findByName(String name);
    
}
