package grupoB.erp.service;

import grupoB.erp.domain.Task;
import java.util.*;

public interface TaskService {
    Task findTaskById(Long id);
    Task saveTask(Task task);
    List<Task> getAllTasks();
    public void delete(Task task);
}
