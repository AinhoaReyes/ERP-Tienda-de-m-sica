package grupoB.erp.service;

import java.util.List;
import grupoB.erp.domain.Product;

public interface ProductService{
    public List<Product> getAll();

    public Product get(Product product);

    public Product getById(Long id);

    public void add(String ref, String name, String description, double cost, double price, Integer minStock, Integer maxStock, boolean isForSale);

    public void save(Product product);

    public void delete(Product product);
    
}
