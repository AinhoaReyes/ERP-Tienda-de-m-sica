package grupoB.erp.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "calendar")
public class Calendar implements Serializable{
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name = "id")
    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name = "tasks")
    private Task task;


}
