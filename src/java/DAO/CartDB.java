
package DAO;

import Models.Cart1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CartDB extends DBContext{
    
    public Cart1 checkCart(int idAccount){
     Cart1 c1=null;
      String sql="select * from Cart where AccountID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, idAccount);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                 c1=new Cart1(rs.getString(1), rs.getInt(2));
            }
        } catch (Exception e) {
        }
      return c1;  
    };

    public void addNewCart(Cart1 newCart) {
        String sql="INSERT INTO [dbo].[Cart]\n" +
"           ([CartID]\n" +
"           ,[AccountID])\n" +
"     VALUES (?,?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, newCart.getIdCart());
            stmt.setInt(2, newCart.getIdAccount());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
