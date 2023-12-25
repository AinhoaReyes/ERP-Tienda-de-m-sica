package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.OrderDAO;
import grupoB.erp.domain.Invoice;
import grupoB.erp.domain.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private InvoiceService invoiceService;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return (List<Order>) orderDAO.findAll();
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

    @Override
    public void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.Delivered) {
            createInvoice(order);
        }
    }

    private void createInvoice(Order order) {
        Invoice invoice = new Invoice();
        invoice.setAmount(0);
        invoice.setTax(0);
        invoice.setTotal(0);
        invoice.setAccountNumber("0");
        invoice.setOrder(order);
        invoiceService.save(invoice);
    }

}
