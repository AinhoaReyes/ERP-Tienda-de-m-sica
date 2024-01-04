package grupoB.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.EventDAO;
import grupoB.erp.dao.UserDAO;
import grupoB.erp.domain.Event;
import java.util.*;

@Service
public class EventServiceImpl implements EventService {

    @Autowired 
    private EventDAO eventDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public Event saveEvent(Event event) {
        // Asignar el usuario al evento si es necesario
        if (event.getUser() != null) {
            event.setUser(userDAO.findByUsername(event.getUser().getUsername()));
        }
        return eventDAO.save(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Long eventId) {
        eventDAO.deleteById(eventId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        return (List<Event>) eventDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByUser(String username) {
        return eventDAO.findByUserUsername(username);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.findById(eventId).orElse(null);
    }
    
}
