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
    @Column(name = "ref")
    private String ref;

    @OneToOne
    @JoinColumn(name = "order_ref", nullable = false)
    private Order order;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;
    
}
