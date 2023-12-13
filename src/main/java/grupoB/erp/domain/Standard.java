package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import java.util.Set;


public class Standard {
    //relaciones
    @OneToOne
    @JoinColumn(name = "user_id")  
    @MapsId
    private User user;

    @ManyToMany
    @JoinTable(
        name = "standard_wishList",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    
    @Column(name = "wish_list")
    private Set<Product> wishList;
}
