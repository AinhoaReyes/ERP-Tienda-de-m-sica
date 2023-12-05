package grupoB.erp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.time.LocalDateTime;

@Entity
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Order> orders;
}
