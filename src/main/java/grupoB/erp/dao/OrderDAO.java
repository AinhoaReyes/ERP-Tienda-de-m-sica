package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;

import grupoB.erp.domain.Order;

public interface OrderDAO extends CrudRepository<Order, Long> {
    Order findByRef(String ref);
}
