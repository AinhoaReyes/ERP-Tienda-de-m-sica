package grupoB.erp.datamodel;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "product_images")
@Data
public class ProductImages {

    @Id
    private Integer id;

    @Column(name = "imageUrl" , nullable = false)
    private String imageUrl;

    @Column(name = "sources", nullable = false)
    private String sources;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
  
}

