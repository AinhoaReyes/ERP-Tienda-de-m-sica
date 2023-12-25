package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "invoice")
@Data
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String ref;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ref")
    private Order order;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double tax;

    @Column(nullable = false)
    private double total;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Invoice(double amount, Timestamp createdAt, Order order) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.order = order;
    }

    public Invoice() {
    }
}
