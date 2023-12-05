package grupoB.erp.domain;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "warehouse")
@Data
public class Warehouse {

    public Warehouse(java.lang.String string3, java.lang.String string4, java.lang.String string5, boolean b) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ref", nullable = false)
    private String ref;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "is_open", nullable = false)
    private boolean isOpen;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private List<Stock> stocks;
}
