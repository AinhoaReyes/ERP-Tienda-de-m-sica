package grupoB.erp.datamodel;

import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock_log")
@Data 
public class StockLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stock_id", nullable = false)
    private int stockId;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
