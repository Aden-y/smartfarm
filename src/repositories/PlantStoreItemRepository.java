package repositories;

import beans.PlantStoreItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class   PlantStoreItemRepository /*extends JpaRepository<PlantStoreItem,Long>*/ {
    private static final  String table = "plantstore";
    public static PlantStoreItem create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new PlantStoreItem(resultSet.getString("name"),
                        resultSet.getString("units"),
                        resultSet.getDouble("quantity"),
                        resultSet.getString("updatedat"),
                        resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<PlantStoreItem> createList(ResultSet resultSet) {
        List<PlantStoreItem> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new PlantStoreItem(resultSet.getString("name"),
                        resultSet.getString("units"),
                        resultSet.getDouble("quantity"),
                        resultSet.getString("updatedat"),
                        resultSet.getLong("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void create(PlantStoreItem object) {
        String sql = "insert into "+table+"(name, units, quantity, updatedat) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getUnits()+"'," +
                ""+object.getQuantity()+"," +
                "'"+object.getUpdatedat()+"'";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(PlantStoreItem object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"'," +
                "units ='"+object.getUnits()+"', " +
                "quantity = "+object.getQuantity()+"," +
                "updatedat = '"+object.getUpdatedat()+"' where id = "+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static PlantStoreItem get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }

    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }


    public static List<PlantStoreItem> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }
}
