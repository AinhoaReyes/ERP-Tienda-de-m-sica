package grupoB.erp.datamodel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity  
@Table(name = "invoice")
@Data
public class Invoice {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private double amount;
    private double tax;
    private double total;
    private String accountNumber;
    private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse; 
}
