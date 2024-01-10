package grupoB.erp.service;

import grupoB.erp.dao.CalendarDAO;
import grupoB.erp.domain.Calendar;
import grupoB.erp.domain.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarDAO calendarDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Calendar> getAll() {
        return (List<Calendar>) calendarDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Calendar getById(Long id) {
        return calendarDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Calendar calendar) {
        calendarDAO.save(calendar);
    }

    @Override
    @Transactional
    public void delete(Calendar calendar) {
        calendarDAO.delete(calendar);
    }

    @Override
    public void save(Task task) {
        
        Calendar c = new Calendar();
        c.setTask(task);
        
    }

    @Override
    public void delete(Task task) {

        Calendar c = new Calendar();
        c.setTask(task);
        calendarDAO.delete(c);
    }
}
