package debug;

import beans.PlantProduct;
import repositories.PlantProductRepository;
import repositories.PlantRepository;

public class Test {
    public static void main(String[] args) {
        PlantProduct product = PlantProductRepository.get((long) 4);
        if (product == null) {
            System.out.println("Nulllll");
        }
        System.out.println(product.getPlantid());
       // PlantProductRepository.all();
       // PlantRepository.all();
    }
}
