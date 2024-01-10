package grupoB.erp.service;

import java.util.List;

import grupoB.erp.domain.Item;

public interface ItemService {
    public List<Item> getByOrderRef(String orderRef);

    public void save(Item item);
}
