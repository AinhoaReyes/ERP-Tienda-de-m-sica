package grupoB.erp.datamodel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long productId;
    private Long warehouseId;
    private Integer stock;  
}
