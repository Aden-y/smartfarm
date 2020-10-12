package repositories;

import beans.Plant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class PlantRepository /*extends JpaRepository<Plant, Long> */{
    private static final  String table = "plants";
    public static Plant create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Plant(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getString("description"),
                        resultSet.getString("plantedon"),
                        resultSet.getInt("rootscount"),
                        resultSet.getLong("farmid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Plant> createList(ResultSet resultSet) {
        List<Plant> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new Plant(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getString("description"),
                        resultSet.getString("plantedon"),
                        resultSet.getInt("rootscount"),
                        resultSet.getLong("farmid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(Plant object) {
        String sql = "insert into "+table+"(name, category, description, plantedon, rootscount, farmid) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getCategory()+"'," +
                "'"+object.getDescription()+"', " +
                "'"+object.getPlantedon()+"', " +
                ""+object.getRootscount()+"," +
                ""+object.getFarmid()+" )";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Plant object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"', " +
                "category = '"+object.getCategory()+"', " +
                "description = '"+object.getDescription()+"', " +
                "plantedon = '"+object.getPlantedon()+"', " +
                "rootscount = "+object.getName()+" where id = "+object.getId() ;
        DatabaseAccess.executeUpdate(sql);
    }

    public static Plant get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Plant> findByParentId(Long id) {
        String sql = "select * from "+table+" where farmid = "+id;
        return createList(DatabaseAccess.executeQuery(sql));
    }
    public static List<Plant> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }

}
