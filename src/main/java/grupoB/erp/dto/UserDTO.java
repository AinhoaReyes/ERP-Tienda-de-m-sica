package grupoB.erp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username, email, phone, address, newPassword;

    public UserDTO() {
    }
}
