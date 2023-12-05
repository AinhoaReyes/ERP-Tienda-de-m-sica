package grupoB.erp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instrument")
@Data
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "material")
    private String material;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private InstrumentType type;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    // Otros campos y métodos según sea necesario
}



