package grupoB.erp.domain;

import lombok.Data;

@Data
public class Product {
    private String name, ref;
    private int stock;
    private double price;
    private boolean isForSale;

    public Product(String name, String ref, int stock, double price, boolean isForSale) {
        this.name = name;
        this.ref = ref;
        this.stock = stock;
        this.price = price;
        this.isForSale = isForSale;
    }
}
