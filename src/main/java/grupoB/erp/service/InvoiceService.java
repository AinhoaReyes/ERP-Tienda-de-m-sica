package grupoB.erp.service;

import java.util.List;
import grupoB.erp.domain.Invoice;

public interface InvoiceService {

    
    Invoice save(Invoice invoice);

    void delete(Invoice invoice);

    List<Invoice> getAll();
}
