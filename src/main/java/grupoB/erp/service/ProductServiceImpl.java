package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.ProductDAO;
import grupoB.erp.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductDAO productDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return (List<Product>) productDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product get(Product product) {
        return productDAO.findById(product.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getByRef(String ref) {
        return productDAO.findByRef(ref);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

}
