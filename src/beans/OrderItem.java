package beans;

import components.OrderItemType;

public class OrderItem {
    protected Long id;
    private String name;
    private String description;
    private int quantity;
    private int orderId;
    private double price;
    private double amount;
    public OrderItemType type;
    public Long idOriginal;

    public OrderItem(Long id, String name, String description, int quantity, int orderId, double price, double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.orderId = orderId;
        this.price = price;
        this.amount = amount;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        calculateAmount();
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void calculateAmount() {
        amount = quantity * price;
    }

    public void add() {
        quantity++;
        amount+=price;
    }


}
