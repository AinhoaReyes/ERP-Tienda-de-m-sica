package grupoB.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

public class Employee {
    enum EmployeeRole{
        employee, administrator
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user; 
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
