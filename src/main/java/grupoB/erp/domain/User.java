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
    private String firstname;
    private String lastname;

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

    public String getFullname() {
        return firstname + " " + lastname;
    }

    public User(Long id, String firstname, String lastname, String hashedPassword) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hashedPassword = hashedPassword;
    }
}
