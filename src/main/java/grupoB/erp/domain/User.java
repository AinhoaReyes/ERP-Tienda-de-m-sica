package grupoB.erp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String username;

    @Column(name = "hashed_password")
    private String hashedPassword;

    private String email;
    private String avatar;
    private String phone;
    private String address;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public User() {
    }

    public User(Long id, String email, String hashedPassword) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }
}
