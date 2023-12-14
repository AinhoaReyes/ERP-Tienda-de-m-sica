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
import java.util.Date;

@Entity  
@Table(name = "invoice")
@Data
public class Invoice implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double tax;

    @Column(nullable = false)
    private double total;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    
    @Id
    @OneToOne
    @JoinColumn(name = "ref", referencedColumnName = "ref")
    private Order order;

    public Invoice(double amount, String ref, Date date){

    }
}
