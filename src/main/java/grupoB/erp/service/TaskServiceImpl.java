package grupoB.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupoB.erp.domain.*;
import java.util.List;


import grupoB.erp.dao.TaskDAO;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;


    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public Task saveTask(Task task) {
        return taskDAO.save(task);
    }

    @Override
    public Task findTaskById(Long id) {
        return taskDAO.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskDAO.findAll();
    }
}

