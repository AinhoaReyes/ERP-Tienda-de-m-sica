package grupoB.erp.service;

import java.util.List;

import grupoB.erp.domain.Order;

public interface OrderService {
    public List<Order> getAll();

    public Order get(Order order);

    public Order getById(Long id);

    public Order getByRef(String ref);

    public void save(Order order);

    public void delete(Order order);

}
