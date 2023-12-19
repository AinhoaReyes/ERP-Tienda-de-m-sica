package grupoB.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import grupoB.erp.domain.Order;
import grupoB.erp.domain.Product;
import grupoB.erp.domain.User;
import grupoB.erp.service.OrderService;
import grupoB.erp.service.ProductService;
import grupoB.erp.domain.Warehouse;
import grupoB.erp.service.UserService;
import grupoB.erp.service.WarehouseService;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private OrderService orderService;

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
        try {
            userService.save(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not update the entity");
        }
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resorce not found");
        try {
            userService.delete(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not delete the entity");
        }
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@ModelAttribute Product data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        try {
            productService.save(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not add the entity");
        }
        return ResponseEntity.ok("Added successfully");
    }

    @PostMapping("/product/{id}/update")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @ModelAttribute Product data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        Product product = productService.getById(id);
        if (product == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        product.setRef(data.getRef());
        product.setName(data.getName());
        product.setDescription(data.getDescription());
        product.setCost(data.getCost());
        product.setPrice(data.getPrice());
        product.setMinStock(data.getMinStock());
        product.setMaxStock(data.getMaxStock());
        product.setForSale(data.isForSale());
        try {
            productService.save(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not update the entity");
        }
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/product/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        try {
            productService.delete(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not delete the entity");
        }
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/warehouse/add")
    public ResponseEntity<String> addWarehouse(@ModelAttribute Warehouse data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        try {
            warehouseService.save(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not add the entity");
        }
        return ResponseEntity.ok("Added successfully");
    }

    @PostMapping("/warehouse/{id}/update")
    public ResponseEntity<String> updateWarehouse(@PathVariable Long id, @ModelAttribute Warehouse data) {
        if (data == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: No data was given");
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        warehouse.setRef(data.getRef());
        warehouse.setAddress(data.getAddress());
        warehouse.setPhone(data.getPhone());
        warehouse.setOpen(data.isOpen());
        try {
            warehouseService.save(warehouse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not update the entity");
        }
        return ResponseEntity.ok("Updated successfully");
    }

    @DeleteMapping("/warehouse/{id}/delete")
    public ResponseEntity<String> deleteWarehouse(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Resource not found");
        try {
            warehouseService.delete(warehouse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: Could not delete the entity");
        }
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/order/add")
    public ResponseEntity<String> addOrder(@ModelAttribute Order order) {
        return ResponseEntity.ok("Added successfully");
    }
}
