
package beans;
/**
 *
 * @author vworldstudios
 */

public class AnimalProduct {
    private String name;
    private String description;
    private String  units;
    private double quantity;
    private double price;
    private Long animalid;
    private Long id;

    public AnimalProduct(String name, String description, String units, double quantity, double price, Long animalid, Long id) {
        this.name = name;
        this.description = description;
        this.units = units;
        this.quantity = quantity;
        this.price = price;
        this.animalid = animalid;
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

    public void setAnimalid(Long animalid) {
        this.animalid = animalid;
    }

    public Long getAnimalid() {
        return animalid;
    }
   
}
