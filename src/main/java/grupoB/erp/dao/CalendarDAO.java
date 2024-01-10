package grupoB.erp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grupoB.erp.domain.Calendar;
import grupoB.erp.domain.User;

public interface CalendarDAO extends CrudRepository<Calendar, Long> {
    List<Calendar> findByUserId(Long userId);

    Optional<Calendar> findById(Long id);
}