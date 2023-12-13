package grupoB.erp;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import grupoB.erp.domain.User;
import grupoB.erp.service.UserService;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/{id}/update")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @ModelAttribute User data) {
        User user = userService.getById(id);
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        user.setAddress(data.getAddress());
        user.setUpdatedAt(Timestamp.from(Instant.now()));
        userService.save(user);
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/user/${id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resorce not found");
        userService.delete(user);
        return ResponseEntity.ok("Deleted successfully");
    }
}
