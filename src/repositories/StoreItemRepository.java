/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import beans.StoreItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vworldstudios
 */
public class StoreItemRepository/* extends JpaRepository<StoreItem, Long>*/ {
    private static final  String table = "storeitems";
    public static StoreItem create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<StoreItem> createList(ResultSet resultSet) {
        List<StoreItem> list = new ArrayList<>();
        try {
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void create(StoreItem object) {
        String sql = "insert into "+table+"() values()";
        DatabaseAccess.executeUpdate(sql);
    }

    public static StoreItem get(Long id) {
        String sql = "select * from "+table+" where id = "+id;
        return create(DatabaseAccess.executeQuery(sql));
    }


    public static void delete(Long id) {
        String sql = "delete from "+table+" where id = "+id;
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<StoreItem> findByParent(Long id) {
        String sql = "select * from "+table+" where plantid = "+id;
        return createList(DatabaseAccess.executeQuery(sql));
    }

    public static void update(StoreItem object) {
        String sql = "update "+table+" set ";
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<StoreItem> all() {
        return createList(DatabaseAccess.executeQuery("select * from "+table));
    }


}
