package grupoB.erp;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import grupoB.erp.domain.User;
import grupoB.erp.service.UserService;

@Controller
public class ApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/{id}/update")
    public String updateUser(
            @PathVariable Long id,
            @ModelAttribute User data) {
        User user = userService.getById(id);
        if (data == null || user == null)
            return "redirect:/settings?error=true";
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        user.setAddress(data.getAddress());
        user.setUpdatedAt(Timestamp.from(Instant.now()));
        userService.save(user);
        return "redirect:/settings";
    }
}
