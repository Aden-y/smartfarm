package beans;

import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class Plant {

    private Long id;
    private String name;
    private String category;
    private String description;
    private String plantedon;
    private int rootscount;
    private List<PlantProduct> products;
    private Long farmid;

    public Plant(Long id, String name, String category, String description, String plantedon, int rootscount, Long farmid) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.plantedon = plantedon;
        this.rootscount = rootscount;
        this.farmid = farmid;
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

    public String getPlantedon() {
        return plantedon;
    }

    

    public void setRootscount(int rootscount) {
        this.rootscount = rootscount;
    }

    public int getRootscount() {
        return rootscount;
    }

    public Long getFarmid() {
        return farmid;
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

    public void setPlantedon(String plantedon) {
        this.plantedon = plantedon;
    }

   

    public void setFarmid(Long farmid) {
        this.farmid = farmid;
    }

    public void setProducts(List<PlantProduct> products) {
        this.products = products;
    }

    public List<PlantProduct> getProducts() {
        return products;
    }
     
    
}
