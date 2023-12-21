package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupoB.erp.dao.InvoiceDAO;
import grupoB.erp.domain.Invoice;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Override
    @Transactional
    public Invoice save(Invoice invoice) {
        return invoiceDAO.save(invoice);
    }

    @Override
    @Transactional
    public void delete(Invoice invoice) {
        invoiceDAO.delete(invoice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Invoice> getAll() {
        return (List<Invoice>) invoiceDAO.findAll();
    }

}
