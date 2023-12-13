package grupoB.erp.service;

import org.springframework.stereotype.Component;

import grupoB.erp.domain.User;
import lombok.Data;

@Data
@Component
public class UserContext {
    private User currentUser;
}