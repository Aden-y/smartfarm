package repositories;

import beans.EquipmentStoreItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
 public class   EquipmentStoreItemRepository /*extends JpaRepository< EquipmentStoreItem,Long> */{

 private static final  String table = "equipmentstore";
 public static EquipmentStoreItem create(ResultSet resultSet) {
  try {
   if (resultSet.next()) {
     return  new EquipmentStoreItem(resultSet.getString("name"),
            resultSet.getDouble("quantity"),
            resultSet.getString("updatedat"),
            resultSet.getLong("id"));
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return null;
 }

 public static List<EquipmentStoreItem> createList(ResultSet resultSet) {
  List<EquipmentStoreItem> list = new ArrayList();
  try {
   while (resultSet.next()) {
    list.add(new EquipmentStoreItem(resultSet.getString("name"),
            resultSet.getDouble("quantity"),
            resultSet.getString("updatedat"),
            resultSet.getLong("id")));
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }

  return list;
 }

 public static void create(EquipmentStoreItem object) {
  String sql = "insert into "+table+"(name, quantity, updatedat) values(" +
          "'"+object.getName()+"'," +
          ""+object.getQuantity()+"," +
          "'"+object.getUpdatedat()+"')";
  DatabaseAccess.executeUpdate(sql);
 }

 public static EquipmentStoreItem get(Long id) {
  String sql = "select * from "+table+" where id = "+id;
  return create(DatabaseAccess.executeQuery(sql));
 }


 public static void delete(Long id) {
  String sql = "delete from "+table+" where id = "+id;
  DatabaseAccess.executeUpdate(sql);
 }

 public static void update(EquipmentStoreItem object) {
  String sql = "update "+table+" set " +
          "name = '"+object.getName()+"'," +
          "quantity = "+object.getQuantity()+"," +
          "updatedat = '"+object.getUpdatedat()+"' where id = "+object.getId();
  DatabaseAccess.executeUpdate(sql);
 }

 public static List<EquipmentStoreItem> all() {
   return createList(DatabaseAccess.executeQuery("select * from "+table));
 }
    
}
