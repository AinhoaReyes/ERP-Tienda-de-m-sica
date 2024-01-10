package grupoB.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import grupoB.erp.domain.*;
import grupoB.erp.dao.*;
import java.util.List;


import grupoB.erp.dao.TaskDAO;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Autowired
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

    @Override
    public void save(Task task) {
        taskDAO.save(task);
    }
}

