package components;
import beans.AnimalProduct;
import beans.OrderItem;
import beans.PlantProduct;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    public static long id;
    public List<OrderItem> items;
    public Cart() {
        items = new ArrayList<>();
    }

    public void add(PlantProduct product) {
        for (OrderItem item: items) {
            if (item.type == OrderItemType.PLANT && item.idOriginal == product.getId()) {
                item.add();
                return;
            }
        }
        OrderItem item1 = new OrderItem(id++, product.getName(),
                product.getDescription(), 1, 0,
                product.getPrice(), product.getPrice());
        item1.type = OrderItemType.PLANT;
        item1.idOriginal = product.getId();
        items.add(item1);
    }

    public void add(AnimalProduct product) {
        for (OrderItem item: items) {
            if (item.type == OrderItemType.ANIMAL && item.idOriginal == product.getId()) {
                item.add();
                return;
            }
        }
        OrderItem item1 = new OrderItem(id++, product.getName(),
                product.getDescription(), 1, 0,
                product.getPrice(), product.getPrice());
        item1.type = OrderItemType.ANIMAL;
        item1.idOriginal = product.getId();
        items.add(item1);
    }

    public void remove(int id) {
        int did = -1;
        for (OrderItem item: items) {
            did++;
            if (item.getId() == id) {
                break;
            }
        }

        items.remove(did);
    }

    public double computeTotal() {
        double total = 0.0;
        for (OrderItem item: items) {
            total+=item.getAmount();
        }
        return total;
    }

    public void checkout() {
        for (OrderItem item: items) {

        }
    }
}
