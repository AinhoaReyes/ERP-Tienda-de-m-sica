package grupoB.erp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import grupoB.erp.domain.Item;

public interface ItemDAO extends CrudRepository<Item, Long> {
    List<Item> findByOrderRef(String orderRef);
}
