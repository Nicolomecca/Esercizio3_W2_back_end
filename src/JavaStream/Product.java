package JavaStream;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    // Costruttore
    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter
  

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    // Metodo setPrice
    public void setPrice(double price) {
        this.price = price;
    }
}