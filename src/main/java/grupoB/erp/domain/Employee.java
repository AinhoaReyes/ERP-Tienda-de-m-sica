package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    enum EmployeeRole {
        employee, administrator
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @Id
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
