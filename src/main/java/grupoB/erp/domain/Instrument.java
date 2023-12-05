package grupoB.erp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instrument")
@Data
public class Instrument {
    @Id
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "brand")
    private String brand;

    @Column(name = "material")
    private String material;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InstrumentType type;
}



