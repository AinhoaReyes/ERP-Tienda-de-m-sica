package grupoB.erp.dto;

import lombok.Data;
import grupoB.erp.domain.Order;

@Data
public class OrderDTO {
    private String ref, warehouse;
    private Order.OrderType type;
    private Order.OrderStatus status;
    private long user;

    public OrderDTO() {
    }
}