package grupoB.erp.domain;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "product_images")
@Data
public class ProductImages {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @Column(name = "image_index", nullable = false)
    private Integer Imageindex;

    @Column(name = "source", nullable = false)
    private String source;
  
}

