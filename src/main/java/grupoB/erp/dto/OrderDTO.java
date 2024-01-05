package grupoB.erp.dto;

import lombok.Data;
import grupoB.erp.domain.Item;
import grupoB.erp.domain.Order;

@Data
public class OrderDTO {
    private String ref, warehouse;
    private Order.OrderType type;
    private long user;
    private Item[] items;

    public OrderDTO() {
    }
}