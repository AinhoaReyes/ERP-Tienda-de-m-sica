package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String ref;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(name = "is_open", nullable = false)
    private Boolean isOpen;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "warehouse")
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "warehouse")
    private Set<Order> orders;

    public Warehouse(String string, String string2, String string3, boolean b) {
    }
}
