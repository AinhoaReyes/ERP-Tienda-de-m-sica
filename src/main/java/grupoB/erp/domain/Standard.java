package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;


@Entity
@Data
@Table(name = "standard")
public class Standard implements Serializable{
    private static final long serialVersionUID = 1L;
    //relaciones
    @OneToOne
    @JoinColumn(name = "user_id")  
    @Id
    private User user;

    @ManyToMany
    @JoinTable(
        name = "standard_wishList",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    
    @Column(name = "wish_list")
    private Set<Product> wishlist;
}
