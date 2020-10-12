
package beans;

/**
 *
 * @author vworldstudios
 */
public class Product {
    private String name;
    private String category;
    private String description;
    private String  units;
    private double quantity;
    private double price;
    private Long id;

    public Product(String name, String category, String description, String units, double quantity, double price, Long id) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.units = units;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getUnits() {
        return units;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
      
}
