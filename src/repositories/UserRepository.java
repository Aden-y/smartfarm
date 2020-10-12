package repositories;


import beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class UserRepository /*extends JpaRepository<User, Long>*/{
   private static final  String table = "users";
   public static User create(ResultSet resultSet) {
      try {
         if (resultSet.next()) {
            return new User(resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("type"),
                    resultSet.getString("registeredon"),
                    resultSet.getString("lasstloged"),
                    resultSet.getInt("phone"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }

   public static List<User> createList(ResultSet resultSet) {
      List<User> list = new ArrayList<>();
      try {
         while (resultSet.next()) {
            list.add(new User(resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("type"),
                    resultSet.getString("registeredon"),
                    resultSet.getString("lasstloged"),
                    resultSet.getInt("phone")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;
   }


   public static void create(User object) {
      String sql = "insert into "+table+"(firstname, lastname, email, password, type, registeredon, lasstloged, phone) values(" +
              "'"+object.getFirstname()+"'," +
              "'"+object.getLastname()+"'," +
              "'"+object.getEmail()+"'," +
              "'"+object.getPassword()+"'," +
              "'"+object.getType()+"'," +
              "'"+object.getRegisteredon()+"'," +
              "'"+object.getLasstloged()+"'," +
              ""+object.getPhone()+")";
      DatabaseAccess.executeUpdate(sql);
   }

   public static User get(Long id) {
      String sql = "select * from "+table+" where id = "+id;
      return create(DatabaseAccess.executeQuery(sql));
   }

   public static User findByEmail(String email) {
      return create(DatabaseAccess.executeQuery("select * from "+table+" where email = '"+email+"'"));
   }


   public static User findByPhone(int phone) {
      return create(DatabaseAccess.executeQuery("select * from "+table+" where phone = "+phone));
   }

   public static void update(User object) {
      String sql = "update "+table+" set " +
              "email = '"+object.getEmail()+"', " +
              "phone = "+object.getPhone()+", " +
              "password = '"+object.getPassword()+"' where id "+object.getId();
      DatabaseAccess.executeUpdate(sql);
   }


   public static void delete(Long id) {
      String sql = "delete from "+table+" where id = "+id;
      DatabaseAccess.executeUpdate(sql);
   }
   public static List<User> all() {
      return createList(DatabaseAccess.executeQuery("select * from "+table));
   }

    public static User login(String email, String password) {
      return create(DatabaseAccess.executeQuery("select * from users where email ='"+email+"' and password = '"+password+"'"));
    }
}
