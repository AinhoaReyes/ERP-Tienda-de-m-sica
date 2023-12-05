package grupoB.erp.datamodel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instrument")
@Data
public class Instrument {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "type", nullable = false)
    private InstrumentType type;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}


