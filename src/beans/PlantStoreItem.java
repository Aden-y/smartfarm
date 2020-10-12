package beans;
/**
 *
 * @author vworldstudios
 */
public class PlantStoreItem {
    private String name;
    private String units;
    private double quantity;
    private String updatedat;
    private Long id;

    public PlantStoreItem(String name, String units, double quantity, String updatedat, Long id) {
        this.name = name;
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

    public String getUnits() {
        return units;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
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
