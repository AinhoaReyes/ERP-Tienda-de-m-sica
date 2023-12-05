package grupoB.erp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "product")
public class Product {
    public Product(String name, String ref, double price, boolean isForSale) {
        this.name = name;
        this.ref = ref;
        this.price = price;
        this.isForSale = isForSale;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ref", unique = true, nullable = false)
    private String ref;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "min_stock")
    private Integer minStock;

    @Column(name = "max_stock")
    private Integer maxStock;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "is_for_sale", columnDefinition = "boolean default false")
    private boolean isForSale;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product")
    private List<ProductImages> productImages;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Instrument instrument;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Track track;

}