package grupoB.erp.dto;


import lombok.Data;

@Data
public class TaskDTO {
    private String name;
    private String description;
    private String date;
    private String time;
    private String priority;

    public TaskDTO() {

    }
}
