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
import grupoB.erp.domain.Warehouse;
import grupoB.erp.service.UserService;
import grupoB.erp.service.WarehouseService;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/user/{id}/update")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @ModelAttribute User data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        User user = userService.getById(id);
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

    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resorce not found");
        userService.delete(user);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/warehouse/add")
    public ResponseEntity<String> addWarehouse(@ModelAttribute Warehouse data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        warehouseService.save(data);
        return ResponseEntity.ok("Added successfully");
    }

    @PostMapping("/warehouse/{id}/udpate")
    public ResponseEntity<String> updateWarehouse(
            @PathVariable Long id,
            @ModelAttribute Warehouse data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        warehouse.setRef(data.getRef());
        warehouse.setAddress(data.getAddress());
        warehouse.setPhone(data.getPhone());
        warehouse.setStatus(data.getStatus());
        warehouse.setUpdatedAt(Timestamp.from(Instant.now()));
        warehouseService.save(warehouse);
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/warehouse/{id}/delete")
    public ResponseEntity<String> deleteWarehouse(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        warehouseService.delete(warehouse);
        return ResponseEntity.ok("Deleted successfully");
    }
}
