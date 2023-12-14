package grupoB.erp;

import java.util.Date;

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
import grupoB.erp.service.UserContext;
import grupoB.erp.service.UserService;

@Controller
public class ErpController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserContext userContext;

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
        Invoice[] data = {
                new Invoice(100.00, "SH01", new Date()),
                new Invoice(140.23, "RE01", new Date()),
        };
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "accounting/index";
    }

    @GetMapping("/warehouses")
    public String warehouses(Model model) {
        Warehouse[] data = {
                new Warehouse("WH01", "1196 Mulberry Street", "647644558", true),
                new Warehouse("WH02", "2448 Joy Lane", "670265854", false),
        };
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/index";
    }

    @GetMapping("/warehouses/{ref}")
    public String warehouse(
            @PathVariable String ref,
            Model model) {
        Warehouse data = new Warehouse(ref, "1196 Mulberry Street", "648645557", true);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/[ref]/index";
    }

    @GetMapping("/warehouses/{ref}/management")
    public String warehouseManagement(
            @PathVariable String ref,
            Model model) {
        Warehouse data = new Warehouse(ref, "1196 Mulberry Street", "648645557", true);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "warehouses/[ref]/management";
    }

    @GetMapping("/products")
    public String products(Model model) {
        Product[] data = {
                new Product("YAMAHA Drum set", "DRUM01", 203.00, true),
                new Product("Yamaha YFL-222 Intermediate Flute", "FLUTE01", 173.69, false),
        };
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/index";
    }

    @GetMapping("/products/{ref}")
    public String product(
            @PathVariable String ref,
            Model model) {
        Product data = new Product("YAMAHA Drum set", "DRUM01", 203.00, true);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/[ref]/index";
    }

    @GetMapping("/products/{ref}/management")
    public String productManagement(
            @PathVariable String ref,
            Model model) {
        Product data = new Product("YAMAHA Drum set", "DRUM01", 203.00, true);
        model.addAttribute("data", data);
        model.addAttribute("user", userContext.getCurrentUser());
        return "products/[ref]/management";
    }
}
