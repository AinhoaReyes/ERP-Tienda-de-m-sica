package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;

import grupoB.erp.domain.Invoice;

public interface InvoiceDAO extends CrudRepository<Invoice, Long> {
    Invoice findByRef(String ref);
}
