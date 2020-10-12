package repositories;


import beans.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository  /*extends JpaRepository<Order, Long> */{
    private static final  String table = "orders";
    public static Order create(ResultSet resultSet) {
        try {
            //Long id, int userid, String date, String status, double amount
            if (resultSet.next()) {
                return new Order(resultSet.getLong("id"),
                        resultSet.getInt("userid"),
                        resultSet.getString("date"),
                        resultSet.getString("status"),
                        resultSet.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Order> createList(ResultSet resultSet) {
        List<Order> list = new ArrayList();
        try {
            while (resultSet.next()) {
                list.add(new Order(resultSet.getLong("id"),
                        resultSet.getInt("userid"),
                        resultSet.getString("date"),
                        resultSet.getString("status"),
                        resultSet.getDouble("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(Order object) {
        String sql = "insert into "+table+"(userid, date, status, amount) values(" +
                ""+object.getCustomer()+"," +
                "'"+object.getDate()+"'," +
                "'"+object.getStatus()+"'," +
                ""+object.getAmount()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Order object) {
        String sql = "update "+table+" set " +
                "status = '"+object.getStatus()+"' where id ="+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static Order get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }



    public static List<Order> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }
}
