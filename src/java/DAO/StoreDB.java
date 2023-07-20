
package DAO;

import Models.Store;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StoreDB extends DBContext{
    
    public List<Store> getAllStore(){
        List<Store> listStore=new ArrayList<>();
        String sql="select * from Store";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Store st=new Store(rs.getInt(1), rs.getString(2), rs.getString(3));
                listStore.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return listStore;
    }
            public static void main(String[] args) {
         StoreDB stdb=new StoreDB();
         List<Store> listStore=stdb.getAllStore();
                for (Store store : listStore) {
                    System.out.println(store.toString());
                }
    }
    
}
