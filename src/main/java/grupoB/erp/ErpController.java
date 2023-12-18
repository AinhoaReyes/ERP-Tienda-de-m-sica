package grupoB.erp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grupoB.erp.domain.Invoice;
import grupoB.erp.domain.Product;
import grupoB.erp.domain.Warehouse;
import grupoB.erp.service.ProductService;
import grupoB.erp.service.UserContext;
import grupoB.erp.service.UserService;
import grupoB.erp.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ErpController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserContext userContext;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "error", required = false, defaultValue = "false") Boolean error,
            @RequestParam(name = "logout", required = false, defaultValue = "false") Boolean logout,
            Model model) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return "login/index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup/index";
    }

    @PostMapping("/signup")
    public String postSignup(
            @RequestParam(name = "username", required = true, defaultValue = "") String username,
            @RequestParam(name = "email", required = true, defaultValue = "") String email,
            @RequestParam(name = "password", required = true, defaultValue = "") String password) {
        userService.add(username, email, password);
        return "redirect:/";
    }

    @GetMapping("/")
    public String root(
            @RequestParam(name = "success", required = false, defaultValue = "false") Boolean success,
            Model model) {
        model.addAttribute("success", success);
        model.addAttribute("user", userContext.getCurrentUser());
        return "index";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("user", userContext.getCurrentUser());
        return "settings/index";
    }

    @GetMapping("/accounting")
    public String accounting(Model model) {
        Invoice[] data = null;
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "accounting/index";
    }

    @GetMapping("/warehouses")
    public String warehouses(Model model) {
        List<Warehouse> data = warehouseService.getAll();
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/index";
    }

    @GetMapping("/warehouses/new")
    public String warehouseNew(Model model) {
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/new";
    }

    @GetMapping("/warehouses/{ref}")
    public String warehouse(
            @PathVariable String ref,
            Model model) {
        Warehouse data = warehouseService.getByRef(ref);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/[ref]/index";
    }

    @GetMapping("/warehouses/{ref}/management")
    public String warehouseManagement(
            @PathVariable String ref,
            Model model) {
        Warehouse data = warehouseService.getByRef(ref);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/[ref]/management";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> data = (List<Product>) productService.getAll();
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/index";
    }

    @GetMapping("/products/new")
    public String productNew(Model model) {
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/new";
    }

    @GetMapping("/products/{ref}")
    public String product(
            @PathVariable String ref,
            Model model) {
        Product data = productService.getByRef(ref);        
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/[ref]/index";
    }

    @GetMapping("/products/{ref}/management")
    public String productManagement(
            @PathVariable String ref,
            Model model) {
        Product data = productService.getByRef(ref);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/[ref]/management";
    }
}
