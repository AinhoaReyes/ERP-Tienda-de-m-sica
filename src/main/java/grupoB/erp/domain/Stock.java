package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "stock")
public class Stock implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int stock;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; 
    
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToMany(mappedBy = "stockId")
    private Set<StockLog> stockLogs;
}
