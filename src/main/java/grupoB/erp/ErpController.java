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
import grupoB.erp.domain.User;
import grupoB.erp.domain.Warehouse;
import grupoB.erp.service.UserService;

@Controller
public class ErpController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
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
    public String root() {
        return "index";
    }

    @GetMapping("/accounting")
    public String accounting(Model model) {
        Invoice[] data = {
                new Invoice(100.00, "SH01", new Date()),
                new Invoice(140.23, "RE01", new Date()),
        };
        model.addAttribute("data", data);
        return "accounting/index";
    }

    @GetMapping("/warehouses")
    public String warehouses(Model model) {
        Warehouse[] data = {
                new Warehouse("WH01", "1196 Mulberry Street", "647644558", true),
                new Warehouse("WH02", "2448 Joy Lane", "670265854", false),
        };
        model.addAttribute("data", data);
        return "warehouses/index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        Product[] data = {
                new Product("YAMAHA Drum set", "DRUM01", 217, 203.00, true),
                new Product("Yamaha YFL-222 Intermediate Flute", "FLUTE01", 500, 173.69, false),
        };
        model.addAttribute("data", data);
        return "products/index";
    }

    @GetMapping("/products/{ref}")
    public String product(
            @PathVariable String ref,
            Model model) {
        Product data = new Product("YAMAHA Drum set", "DRUM01", 217, 203.00, true);
        model.addAttribute("data", data);
        return "products/[ref]/index";
    }

    @GetMapping("/products/{ref}/management")
    public String productManagement(
            @PathVariable String ref,
            Model model) {
        Product data = new Product("YAMAHA Drum set", "DRUM01", 217, 203.00, true);
        model.addAttribute("data", data);
        return "products/[ref]/management";
    }
}
