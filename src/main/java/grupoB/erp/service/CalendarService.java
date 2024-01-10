package grupoB.erp.service;

import grupoB.erp.domain.Calendar;
import grupoB.erp.domain.Task;

import java.util.List;

public interface CalendarService {

    List<Calendar> getAll();

    Calendar getById(Long id);

    void save(Calendar calendar);

    void delete(Calendar calendar);

    void save(Task task);

    void delete(Task task);

    
}
