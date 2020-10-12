package beans;


import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class Farm {
    private Long id;
    private String name;
    private double size;
    private String location;

    public Farm(Long id, String name, double size, String location) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.location = location;
    }

    private List<Plant> plants;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
     
    
    
}
