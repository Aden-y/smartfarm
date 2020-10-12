package beans;


import java.util.List;

public class Order {
    protected Long id;
    private int userid;
    private String date;
    private String status;
    private double amount;
    private List<OrderItem> items;

    public Order(Long id, int userid, String date, String status, double amount) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getCustomer() {
        return userid;
    }

    public void setCustomer(int customer) {
        this.userid = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        calculateAmount();
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void calculateAmount() {
        amount = 0;
        for (OrderItem item: items ) {
            amount+=item.getAmount();
        }
    }
}
