package repositories;

import beans.OrderItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository /*extends JpaRepository<OrderItem, Long> */{
    private static final  String table = "orderitems";
    public static OrderItem create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
               return new OrderItem(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("orderid"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<OrderItem> createList(ResultSet resultSet) {
        List<OrderItem> list = new ArrayList();
        try {
            while (resultSet.next()) {
                list.add(new OrderItem(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("orderid"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"))) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void create(OrderItem object) {
        String sql = "insert into "+table+"(name, description, quantity, orderid, price, amount) values(" +
                "'"+object.getName()+"', " +
                "'"+object.getDescription()+"', " +
                ""+object.getQuantity()+", " +
                ""+object.getOrderId()+", " +
                ""+object.getPrice()+", " +
                ""+object.getAmount()+")" ;
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(OrderItem object) {
        String sql = "update "+table+" set n" +
                "name =  '"+object.getName()+"', " +
                "description =  '"+object.getDescription()+"', " +
                "quantity =  "+object.getQuantity()+", " +
                "quantity =  "+object.getOrderId()+", " +
                "quantity =  "+object.getPrice()+", " +
                "quantity =  "+object.getAmount()+" where id = "+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static OrderItem get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }



    public static List<OrderItem> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }

    public static List<OrderItem> findByParentId(Long id) {
        return createList(DatabaseAccess.executeQuery("select * from orderitems where orderid = "+id));
    }
}
