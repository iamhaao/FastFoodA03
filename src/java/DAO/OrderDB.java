package DAO;

import Models.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDB extends DBContext {

    public void insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([OrderID]"
                + "           ,[AccountID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[TotalAmount]\n"
                + "           ,[StoreID]\n"
                + "           ,[Status]\n"
                + "           ,[Shipper]\n"
                + "           ,[AddressShip]\n"
              +     "           ,[Method])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,order.getIdOrder());
            stmt.setInt(2, order.getIdAccount());
            stmt.setString(3, order.getDate());
            stmt.setDouble(4, order.getPrice());
            stmt.setInt(5, order.getIdStore());
            stmt.setInt(6, 0);
            stmt.setString(8, order.getAddress());
            stmt.setString(7,null);
            stmt.setInt(9, order.getMethod());
            stmt.executeUpdate();
   

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Order> listOrderNotDone(){
        ArrayList<Order> list=new ArrayList<>();
        String sql="execute orderStatus ";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Order o=new Order(rs.getString(1), rs.getInt(2), rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(8), rs.getInt(6), rs.getInt(7),rs.getInt(9));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
 
  public void updateOrder(String id, int idAccount) {
        String sql="update Orders set Shipper=?,Status=? where OrderID=?";
        try {
          PreparedStatement stmt=connection.prepareStatement(sql);
          stmt.setInt(1, idAccount);
          stmt.setInt(2, 1);
          stmt.setString(3, id);
          stmt.executeUpdate();
      } catch (Exception e) {
      }
        
    }
  
  public Order getOrder(String id){
      Order o=new Order();
      String sql="select * from Orders where OrderID=?";
      try {
          PreparedStatement stmt=connection.prepareStatement(sql);
          stmt.setString(1,id);
          ResultSet rs=stmt.executeQuery();
          while (rs.next()) {              
              o.setIdOrder(id);
              o.setIdAccount(rs.getInt(2));
              o.setDate(rs.getString(3));
              o.setPrice(rs.getDouble(4));
              o.setIdStore(rs.getInt(5));
              o.setStatus(rs.getInt(6));
              o.setIdShipper(rs.getInt(7));
              o.setAddress(rs.getString(8));
              o.setMethod(rs.getInt(9));
          }
      } catch (Exception e) {
      }
      return o;
  }
     public List<Order> listOrderByShipper(int id){
        ArrayList<Order> list=new ArrayList<>();
        String sql="select * from Orders where Shipper=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Order o=new Order(rs.getString(1), rs.getInt(2), rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(8), rs.getInt(6), rs.getInt(7),rs.getInt(9));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
  
     public static void main(String[] args) {
        OrderDB odb=new OrderDB();
        List<Order>list=odb.listOrderByShipper(7);
         for (Order order : list) {
             System.out.println(order.toString());
         }
         
         Order o=odb.getOrder("t1ckAr");
         System.out.println(o.toString());
}

    public void updateStatus(int status,String id) {
        String sql="UPDATE ORDERS SET Status=? Where OrderID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, status);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
public double getTotalOrder(int idAccount) {
        double price = 0;
        String sql = "select Sum(TotalAmount)\n"
                + "from Orders \n"
                + "where AccountID=? and Status=2";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, idAccount);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                price=rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return price;
    }
    public List<Order> getListConfirm() {
         ArrayList<Order> list = new ArrayList<>();
        String sql = "Select * from Orders where status=0 order by OrderDate desc ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(8), rs.getInt(6), rs.getInt(7), rs.getInt(9));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
