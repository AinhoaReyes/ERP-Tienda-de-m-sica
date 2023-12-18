package grupoB.erp.domain;

import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@Entity
@Table(name = "product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String ref;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "min_stock")
    private Integer minStock;

    @Column(name = "max_stock")
    private Integer maxStock;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private double price;

    @Column(name = "is_for_sale", columnDefinition = "boolean default false")
    private boolean isForSale;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    //relaciones
    @OneToOne(mappedBy = "product")
    private Instrument instrument;

    @ManyToMany(mappedBy = "wishlist")
    private Set<Standard> standards;

    @OneToMany(mappedBy = "product")
    private Set<ProductImages> productImages;

    @OneToMany(mappedBy = "product")
    private Set<Review> review;

    @OneToMany(mappedBy = "product")
    private Set<Stock> stock;
    
    @OneToMany(mappedBy = "product")
    private Set<Item> items;

    @OneToMany(mappedBy = "product")
    private Set<Track> tracks;

    public Product() {
    }
}