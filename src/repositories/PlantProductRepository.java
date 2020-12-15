package repositories;


import beans.PlantProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class PlantProductRepository  /*extends JpaRepository<PlantProduct, Long>*/{
    private static final  String table = "plantproducts";
    public static PlantProduct create(ResultSet resultSet) {
        System.out.println("Here");
        try {
            System.out.println("In try");

                if (resultSet.next()) {
                    System.out.println("Found object");
                    return  new PlantProduct(resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getString("units"),
                            resultSet.getDouble("quantity"),
                            resultSet.getDouble("price"),
                            resultSet.getLong("plantid"),
                            resultSet.getLong("id"));
                }

        } catch (SQLException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        return null;
    }

    public static List<PlantProduct> createList(ResultSet resultSet) {
        List<PlantProduct> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add( new PlantProduct(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("units"),
                        resultSet.getDouble("quantity"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("plantid"),
                        resultSet.getLong("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(PlantProduct object) {
        String sql = "insert into "+table+"(name, description, units, quantity, price, plantid) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getDescription()+"'," +
                "'"+object.getUnits()+"'," +
                ""+object.getQuantity()+"," +
                ""+object.getPrice()+"," +
                ""+object.getPlantid()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static PlantProduct get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        System.out.println(sql);
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<PlantProduct> findByParentId(Long id) {
        String sql = "select * from "+table+" where plantid = "+id;
        return createList(DatabaseAccess.executeQuery(sql));
    }

    public static void update(PlantProduct object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"', " +
                "description = '"+object.getDescription()+"', " +
                "units = '"+object.getUnits()+"', " +
                "quantity = "+object.getQuantity()+", " +
                "price = "+object.getPrice()+" where id = "+object.getId() ;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<PlantProduct> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }

    public static void sell(Long idOriginal, int quantity) {
        PlantProduct product = get(idOriginal);
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            update(product);
        }
    }
}
