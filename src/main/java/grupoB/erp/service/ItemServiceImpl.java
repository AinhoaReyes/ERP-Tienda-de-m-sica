package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.ItemDAO;
import grupoB.erp.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Item> getByOrderRef(String orderRef) {
        return (List<Item>) itemDAO.findByOrderRef(orderRef);
    }

    @Override
    @Transactional
    public void save(Item item) {
        itemDAO.save(item);
    }
}
