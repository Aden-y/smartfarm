package beans;
/**
 *
 * @author vworldstudios
 */

public class StoreItem {
    private String name;
    private String category;
    private String units;
    private double quantity;
    private String updatedat;
    private Long id;

    public StoreItem(String name, String category, String units, double quantity, String updatedat, Long id) {
        this.name = name;
        this.category = category;
        this.units = units;
        this.quantity = quantity;
        this.updatedat = updatedat;
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

    public void setUnits(String units) {
        this.units = units;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }
    
    
    
}
