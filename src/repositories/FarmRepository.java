package repositories;

import beans.Farm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class FarmRepository /* extends JpaRepository<Farm, Long>*/{
    private static final  String table = "farms";
    public static Farm create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Farm(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("size"),
                        resultSet.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Farm> createList(ResultSet resultSet) {
        List<Farm> list = new ArrayList();
        try {
            while (resultSet.next()) {
                list.add(new Farm(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("size"),
                        resultSet.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(Farm object) {
        String sql = "insert into "+table+"(name, size, location) values(" +
                "'"+object.getName()+"'," +
                ""+object.getSize()+"," +
                "'"+object.getLocation()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Farm get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Farm object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"', " +
                "size = "+object.getSize()+", " +
                "location = '"+object.getLocation()+"' where id = "+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Farm> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }
}
