package grupoB.erp;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import grupoB.erp.domain.Invoice;
import grupoB.erp.domain.Product;
import grupoB.erp.domain.Warehouse;

@Controller
public class ErpController {

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
