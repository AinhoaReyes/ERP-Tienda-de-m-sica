package grupoB.erp.service;

import grupoB.erp.domain.Event;
import java.util.*;

public interface EventService {
    
    Event saveEvent(Event event);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();

    List<Event> getEventsByUser(String username);

    void deleteEvent(Long eventId);

}
