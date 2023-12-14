package grupoB.erp.service;

import java.util.List;

import grupoB.erp.domain.Warehouse;

public interface WarehouseService {

    public List<Warehouse> getAll();

    public Warehouse get(Warehouse warehouse);

    public Warehouse getById(Long id);

    public void save(Warehouse warehouse);

    public void delete(Warehouse warehouse);
}
