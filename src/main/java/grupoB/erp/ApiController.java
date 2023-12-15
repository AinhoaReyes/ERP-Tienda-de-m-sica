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

import grupoB.erp.domain.Product;
import grupoB.erp.domain.User;
import grupoB.erp.service.ProductService;
import grupoB.erp.service.UserService;


@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

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

    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resorce not found");
        userService.delete(user);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@ModelAttribute Product data){
        if(data == null)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        productService.save(data);
        return ResponseEntity.ok("Added successfully");
    }

    @PostMapping("/product/{id}/update")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @ModelAttribute Product data){
        if(data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        Product product = productService.getById(id);
        if(product == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        product.setRef(data.getRef());
        product.setName(data.getName());
        product.setDescription(data.getDescription());
        product.setCost(data.getCost());
        product.setPrice(data.getPrice());
        product.setMinStock(data.getMinStock());
        product.setMaxStock(data.getMaxStock());
        product.setForSale(data.isForSale());
        productService.save(product);
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/product/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        Product product = productService.getById(id);
        if(product == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        productService.delete(product);
        return ResponseEntity.ok("Deleted successfully");
    }
}
