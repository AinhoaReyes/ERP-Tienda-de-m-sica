package grupoB.erp.domain;

import java.io.Serializable;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum TaskPriority {
        highest, high, medium, low, lowest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    @Column(name = "all_day", columnDefinition = "boolean default true")
    private boolean allDay;

    @OneToMany(mappedBy = "task")
    private Set<Calendar> calendars;


}
