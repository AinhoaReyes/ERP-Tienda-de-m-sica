package grupoB.erp.datamodel;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "warehouse_ref")
    private String warehouseRef;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // getters and setters
}
