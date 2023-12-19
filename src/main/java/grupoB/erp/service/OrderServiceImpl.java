package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.OrderDAO;
import grupoB.erp.dao.ProductDAO;
import grupoB.erp.domain.Order;
import grupoB.erp.domain.Product;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderDAO orderDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return (List<Order>) orderDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order get(Order order) {
        return orderDAO.findById(order.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long id) {
        return orderDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getByRef(String ref) {
        return orderDAO.findByRef(ref);
    }

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

}
