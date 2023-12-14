package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name = "instrument")
public class Instrument implements Serializable{
    private static final long serialVersionUID = 1L;

    enum InstrumentType {
        percussion, strings, wind
    }
    @OneToOne
    @Id
    @JoinColumn(name = "product_id")
    private Product product;

    private String brand;
    private String material;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InstrumentType type;

    
}



