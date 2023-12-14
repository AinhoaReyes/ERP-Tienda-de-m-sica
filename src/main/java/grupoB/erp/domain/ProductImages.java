package grupoB.erp.domain;

import lombok.Data;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "product_images")
public class ProductImages implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "`index`", nullable = false)
    private int index;

    @Column(nullable = false)
    private String source;

    // relaciones
    @ManyToOne
    @JoinColumn(name = "product_id")
    @Id
    private Product product;

}
