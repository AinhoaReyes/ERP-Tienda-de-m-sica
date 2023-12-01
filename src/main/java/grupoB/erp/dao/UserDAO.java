package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;
import grupoB.erp.domain.User;

public interface UserDAO extends CrudRepository<User, Long> {
}
