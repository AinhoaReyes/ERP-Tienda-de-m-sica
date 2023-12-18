package grupoB.erp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(name = "hashed_password", nullable = false)
    private String password;

    private String avatar;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(nullable = true)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // relaciones
    @OneToOne(mappedBy = "user")
    private Standard standard;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    private Set<Review> review;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
