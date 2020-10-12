package repositories;

import beans.AnimalStoreItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class   AnimalStoreItemRepository/* extends JpaRepository<AnimalStoreItem,Long>*/ {

    private static final  String table = "animalstore";
    public static AnimalStoreItem create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new AnimalStoreItem(resultSet.getString("name"),
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

    public static List<AnimalStoreItem> createList(ResultSet resultSet) {
        List<AnimalStoreItem> list = new ArrayList();
        try {
            while (resultSet.next()) {
                list.add(new AnimalStoreItem(resultSet.getString("name"),
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

    public static void create(AnimalStoreItem object) {
        String sql = "insert into "+table+"(name, units, quantity, updatedat) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getUnits()+"'," +
                ""+object.getQuantity()+"," +
                "'"+object.getUpdatedat()+"'";
        DatabaseAccess.executeUpdate(sql);
    }

    public static AnimalStoreItem get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(AnimalStoreItem object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"'," +
                "units ='"+object.getUnits()+"', " +
                "quantity = "+object.getQuantity()+"," +
                "updatedat = '"+object.getUpdatedat()+"' where id = "+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<AnimalStoreItem> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }
    
}
