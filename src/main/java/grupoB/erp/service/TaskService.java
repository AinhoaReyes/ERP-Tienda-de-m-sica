package grupoB.erp.service;

import grupoB.erp.domain.Task;
import java.util.*;

public interface TaskService {
    Task saveTask(Task task);
    Task findTaskById(Long id);
    List<Task> getAllTasks();
    void save(Task task);
}
