package beans;

/**
 *
 * @author vworldstudios
 */

public class EquipmentStoreItem {
    private String name;
    private double quantity;
    private String updatedat;
    private Long id;

    public EquipmentStoreItem(String name, double quantity, String updatedat, Long id) {
        this.name = name;
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

    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
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
