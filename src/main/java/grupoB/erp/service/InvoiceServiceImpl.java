package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.InvoiceDAO;
import grupoB.erp.domain.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    public InvoiceDAO invoiceDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Invoice> getAll() {
        return (List<Invoice>) invoiceDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Invoice getByRef(String ref) {
        return invoiceDAO.findByRef(ref);
    }

    @Override
    @Transactional
    public void save(Invoice invoice) {
        invoiceDAO.save(invoice);
    }

    @Override
    @Transactional
    public void delete(Invoice invoice) {
        invoiceDAO.delete(invoice);
    }

}
