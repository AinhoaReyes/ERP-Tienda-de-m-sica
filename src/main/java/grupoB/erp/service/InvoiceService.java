package grupoB.erp.service;

import java.util.List;

import grupoB.erp.domain.Invoice;

public interface InvoiceService {
    public List<Invoice> getAll();

    public Invoice getByRef(String ref);

    public void save(Invoice invoice);

    public void delete(Invoice invoice);

}
