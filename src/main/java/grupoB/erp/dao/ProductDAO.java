package grupoB.erp.dao;

import org.springframework.data.repository.CrudRepository;
import grupoB.erp.domain.Product;

public interface ProductDAO extends CrudRepository<Product, Long>{
    
}
