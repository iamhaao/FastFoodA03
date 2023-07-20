
package DAO;

import static DAO.DBContext.connection;
import Models.Cart;
import Models.OrderDetails;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrderDetailsDB extends DBContext{
    
    public boolean insertOrderDetails(OrderDetails orderdetails){
        boolean result=false;
       String sql="INSERT INTO [dbo].[OrderDetails]\n" +
"           ([OrderID]\n" +
"           ,[ProductID]\n" +
"           ,[Quantity]\n" +
"           ,[PriceDetails])\n" +
"     VALUES(?,?,?,?)"; 
        
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, orderdetails.getIdOrder());
            stmt.setInt(2, orderdetails.getIdProduct());
            stmt.setInt(3, orderdetails.getquantityProduct());
            stmt.setDouble(4,orderdetails.getPriceDetails());
            stmt.executeUpdate();
            result=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    public List<OrderDetails> listDetails(String id){
        List<OrderDetails> list=new ArrayList<>();
        String sql="select * from OrderDetails where OrderID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs=stmt.executeQuery();
            ProductDB pdb=new ProductDB();
            while (rs.next()) {
               Product p= pdb.getProductByID(rs.getInt(2));
                OrderDetails odt=new OrderDetails(rs.getString(1), rs.getInt(3), rs.getDouble(4), p.getIdProduct(),p.getName(), p.getDescription(), p.getPrice(),p.getImage(), p.getIdCatory(), p.getQuantity(),p.getCreatedAt());
                list.add(odt);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        OrderDetailsDB odtdb=new OrderDetailsDB();
        List<OrderDetails> list=odtdb.listDetails("3vlhST");
        for (OrderDetails orderDetails : list) {
            System.out.println(orderDetails.toString());
        }
        
    }
    public ArrayList<Cart> getBuyAgain(String orderID) {
        ArrayList<Cart> buyAgain=new ArrayList<>();
        String sql="select * from OrderDetails where OrderID=?";
        ProductDB pdb=new ProductDB();
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1,orderID);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Product p=pdb.getProductByID(rs.getInt(2));
                Cart c=new Cart(rs.getInt(3), p.getIdProduct(), p.getImage(), p.getDescription(), p.getPrice(), p.getImage(), p.getIdCatory(), p.getQuantity(), p.getCreatedAt());
                buyAgain.add(c);
            }
            
        } catch (Exception e) {
        }  
        return buyAgain;
    }
    
    
        public void updateCancel(String orderID) {
        String sql = "UPDATE [dbo].[OrderDetails]\n"
                + "   SET \n"
                + "      [Quantity] =?\n"
                + " WHERE OrderID=?";
            try {
                     PreparedStatement stmt=connection.prepareStatement(sql);
                     stmt.setInt(1, 0);
                     stmt.setString(2, orderID);
                     stmt.executeUpdate();
            } catch (Exception e) {
            }
   
    }

}
