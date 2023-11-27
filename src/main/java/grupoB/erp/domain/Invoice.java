package grupoB.erp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Invoice {
    private double amount;
    private String ref;
    private Date createdAt;

    public Invoice(double amount, String ref, Date createdAt) {
        this.amount = amount;
        this.ref = ref;
        this.createdAt = createdAt;
    }
}
