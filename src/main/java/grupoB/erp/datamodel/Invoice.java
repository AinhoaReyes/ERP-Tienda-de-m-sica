package grupoB.erp.datamodel;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity  
@Table(name = "invoice")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "amount")
    private double amount;

    @Column(name = "tax")
    private double tax;

    @Column(name = "total")
    private double total;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "warehouse")
    private List<Invoice> invoices;
    
}
