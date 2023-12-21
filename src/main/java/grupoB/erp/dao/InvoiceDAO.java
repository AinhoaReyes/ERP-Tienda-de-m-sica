package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;

import grupoB.erp.domain.Invoice;
import grupoB.erp.domain.Order;
public interface InvoiceDAO extends CrudRepository<Invoice, Order> {
    Invoice findByOrder(Order order);
}

