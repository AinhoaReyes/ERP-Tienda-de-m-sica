package grupoB.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.WarehouseDAO;
import grupoB.erp.domain.Warehouse;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDAO warehouseDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Warehouse> getAll() {
        return (List<Warehouse>) warehouseDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Warehouse get(Warehouse warehouse) {
        return warehouseDAO.findById(warehouse.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Warehouse getById(Long id) {
        return warehouseDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Warehouse getByRef(String ref) {
        return warehouseDAO.findByRef(ref);
    }

    @Override
    @Transactional
    public void save(Warehouse warehouse) {
        warehouseDAO.save(warehouse);
    }

    @Override
    @Transactional
    public void delete(Warehouse warehouse) {
        warehouseDAO.delete(warehouse);
    }
}
