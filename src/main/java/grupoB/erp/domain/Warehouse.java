package grupoB.erp.domain;

import lombok.Data;

@Data
public class Warehouse {
    private String ref, address, phone;
    private boolean isOpen;

    public Warehouse(String ref, String address, String phone, boolean isOpen) {
        this.ref = ref;
        this.address = address;
        this.phone = phone;
        this.isOpen = isOpen;
    }
}
