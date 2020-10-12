package repositories;


import beans.Animal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class AnimalRepository /*extends JpaRepository<Animal, Long>*/{
    private static final  String table = "animals";
    public static Animal create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Animal (resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("color"),
                        resultSet.getString("category"),
                        resultSet.getString("breed"),
                        resultSet.getString("gender"),
                        resultSet.getDouble("weight"),
                        resultSet.getString("dob"),
                        resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Animal> createList(ResultSet resultSet) {
        List<Animal> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new Animal (resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("color"),
                        resultSet.getString("category"),
                        resultSet.getString("breed"),
                        resultSet.getString("gender"),
                        resultSet.getDouble("weight"),
                        resultSet.getString("dob"),
                        resultSet.getInt("count")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(Animal object) {
        String sql = "insert into "+table+"(name, color, category, breed, gender, weight, dob, count) values(" +
                "'"+object.getName()+"'," +
                "'"+object.getColor()+"'," +
                "'"+object.getCategory()+"'," +
                "'"+object.getBreed()+"'," +
                "'"+object.getGender()+"'," +
                ""+object.getWeight()+"," +
                "'"+object.getDob()+"'," +
                ""+object.getCount()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Animal object) {
        String sql = "update "+table+" set " +
                "name = '"+object.getName()+"', " +
                "color = '"+object.getColor()+"', " +
                "category = '"+object.getCategory()+"', " +
                "breed = '"+object.getBreed()+"', " +
                "gender = '"+object.getGender()+"', " +
                "weight = "+object.getWeight()+", " +
                "dob = '"+object.getDob()+"', " +
                "count ="+object.getCount()+" where id = "+object.getId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static Animal get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Animal> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }
}
