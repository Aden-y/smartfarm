
package beans;
import repositories.AnimalProductRepository;

import java.util.List;
/**
 *
 * @author vworldstudios
 */
public class Animal{
    protected Long id;
    private String name;
    private String color;
    private String category;
    private String breed;
    private String gender;
    private double weight;
    private String dob;
    private int count;

    public Animal(Long id, String name, String color, String category, String breed, String gender, double weight, String dob, int count) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.category = category;
        this.breed = breed;
        this.gender = gender;
        this.weight = weight;
        this.dob = dob;
        this.count = count;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private List<AnimalProduct> products;
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public String getDob() {
        return dob;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AnimalProduct> getProducts() {
       return AnimalProductRepository.findByParentId(id);
    }

    public void setProducts(List<AnimalProduct> products) {
        this.products = products;
    }
    
    
    
    
    
}
