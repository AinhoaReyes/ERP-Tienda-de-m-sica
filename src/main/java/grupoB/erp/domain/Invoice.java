package grupoB.erp.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity  
@Table(name = "invoice")
@Data
public class Invoice {
    public Invoice(double e, java.lang.String string2, Date date) {
    }

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

    @ManyToOne
    @JoinColumn(name = "invoice_id")  // Assuming "invoice_id" is the foreign key column in the InvoiceItem table
    private Invoice invoice;
    
}
