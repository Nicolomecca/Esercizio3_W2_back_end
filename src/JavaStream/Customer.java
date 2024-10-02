package JavaStream;

public class Customer {
    private long id;
    private String name;
    private Integer tier;

    // Costruttore
    public Customer(long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }
}