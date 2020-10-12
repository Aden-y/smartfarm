package repositories;


import beans.AnimalProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class AnimalProductRepository /* extends JpaRepository<AnimalProduct, Long>*/{

    private static final  String table = "animalproducts";
    public static AnimalProduct create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new AnimalProduct(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("units"),
                        resultSet.getDouble("quantity"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("animalid"),
                        resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<AnimalProduct> createList(ResultSet resultSet) {
        List<AnimalProduct> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add( new AnimalProduct(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("units"),
                        resultSet.getDouble("quantity"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("animalid"),
                        resultSet.getLong("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(AnimalProduct object) {
        String sql = "insert into "+table+"(name, description, units, quantity, price, animalid) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getDescription()+"'," +
                "'"+object.getUnits()+"'," +
                ""+object.getQuantity()+"," +
                ""+object.getPrice()+"," +
                ""+object.getAnimalid()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(AnimalProduct object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"', " +
                "description = '"+object.getDescription()+"', " +
                "units = '"+object.getUnits()+"', " +
                "quantity = "+object.getQuantity()+", " +
                "price = "+object.getPrice()+" where id = "+object.getId() ;
        DatabaseAccess.executeUpdate(sql);
    }

    public static AnimalProduct get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<AnimalProduct> findByAnimalId(Long id) {
        String sql = "select * from "+table+" where animalid = "+id;
        return createList(DatabaseAccess.executeQuery(sql));
    }



    public static List<AnimalProduct> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }

}
