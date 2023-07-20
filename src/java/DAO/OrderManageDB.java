
package DAO;

import Models.Account;
import Models.OrderManage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderManageDB extends DBContext{
    
    
    public List<OrderManage> getAll(){
        AccountDB adb=new AccountDB();
      List<OrderManage> list=new ArrayList<>();
      String sql="select a.Username,a.name,s.Name,a.Phone,o.OrderID,o.AccountID,o.OrderDate,o.TotalAmount,o.StoreID,o.AddressShip,o.Status,o.Shipper,o.Method\n" +
"from Orders o,Account a,Store s\n" +
"where o.AccountID=a.AccountID and o.StoreID=s.StoreID \n" +
"order by  o.OrderDate desc";  
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Account acc = adb.getAccountByID(rs.getInt(12)); 
                OrderManage om=new OrderManage(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),acc.getName());
                list.add(om);
            }
        } catch (Exception e) {
        }     
        return list;
    };
     public List<OrderManage> getOrderByShipper(int id){
      List<OrderManage> list=new ArrayList<>();
      String sql="select a.Username,a.name,s.Name,a.Phone,o.OrderID,o.AccountID,o.OrderDate,o.TotalAmount,o.StoreID,o.AddressShip,o.Status,o.Shipper,o.Method\n" +
"from Orders o,Account a,Store s\n" +
"where o.AccountID=a.AccountID and o.StoreID=s.StoreID and o.Shipper=? "
              + " order by  o.OrderDate desc";  
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                AccountDB adb=new AccountDB();
                Account acc=adb.getAccountByID(rs.getInt(12));
                OrderManage om=new OrderManage(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),acc.getName());
                list.add(om);
            }
        } catch (Exception e) {
        }     
        return list;
    };
     
     
     public static void main(String[] args) {
        OrderManageDB omdb=new OrderManageDB();
        List<OrderManage> list=omdb.getOrderByUser(3);
         for (OrderManage orderManage : list) {
             System.out.println(orderManage.toString());
         }
    }

    public List<OrderManage> getOrderByUser(int id) {
      String sql="select a.Username,a.name,s.Name,a.Phone,o.OrderID,o.AccountID,o.OrderDate,o.TotalAmount,o.StoreID,o.AddressShip,o.Status,o.Shipper,o.Method\n" +
"from Orders o,Account a,Store s\n" +
"where o.AccountID=a.AccountID and o.StoreID=s.StoreID and o.AccountID=? "
              + " order by  o.OrderDate desc";  
      List<OrderManage> list=new ArrayList<>();
      
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                AccountDB adb=new AccountDB();
                Account acc=adb.getAccountByID(rs.getInt(12));
                OrderManage om=new OrderManage(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),acc.getName());
                list.add(om);
            }
            
            
        } catch (Exception e) {
        }
        return list;
    };
}
