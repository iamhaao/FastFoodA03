
package DAO;

import Models.Cart;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CartDetailDB extends DBContext{
    
    
    
    public List<Cart> getCart(String idCart){
        List<Cart> list=new ArrayList<>();
        String sql=" select * from CartDetails where CartID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, idCart);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {   
                ProductDB pdb=new ProductDB();
                Product p=pdb.getProductByID(rs.getInt(2));
                Cart c=new Cart(rs.getInt(3), rs.getInt(2), p.getName(), p.getDescription(), p.getPrice(), p.getImage(), p.getIdCatory(), p.getQuantity(), p.getCreatedAt());
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addCartDetail(String idCart,int idProduct,int quantity){
       String sql="INSERT INTO [dbo].[CartDetails]\n" +
"           ([CartID]\n" +
"           ,[ProductID]\n" +
"           ,[quantityCart])\n" +
"     VALUES(?,?,?)";  
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, idCart);
            stmt.setInt(2, idProduct);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    };

    public void deleteAll(String idCart) {
        String sql="DELETE FROM [dbo].[CartDetails]\n" +
"      WHERE CartID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, idCart);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String idCart, int idProduct) {
        String sql="DELETE FROM [dbo].[CartDetails]\n" +
"      WHERE CartID=? and ProductID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, idCart);
            stmt.setInt(2, idProduct);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateQuantity(String idCart, int idProduct, int quantity) {
         String sql="UPDATE [dbo].[CartDetails]\n" +
"   SET [quantityCart] = ?\n" +
" WHERE CartID=? and ProductID=?";
         try {
             PreparedStatement stmt=connection.prepareStatement(sql);
             stmt.setInt(1, quantity);
             stmt.setString(2, idCart);
             stmt.setInt(3, idProduct);
             stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
