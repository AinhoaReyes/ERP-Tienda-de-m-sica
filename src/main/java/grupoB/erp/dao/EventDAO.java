package grupoB.erp.dao;

import grupoB.erp.domain.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventDAO extends CrudRepository<Event, Long> {

    List<Event> findByUserUsername(String username);

}
