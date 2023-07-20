/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Models.Feedback;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class FeedbackDB  extends DBContext {
    public List<Feedback> getAllFeedback(int productId) {
        List<Feedback> listFeedback = new ArrayList<>();
        String sql = "select f.AccountID,f.AccountID,a.name,a.avatar,f.scrip,f.date,f.rating\n" +
"from Feedback f,Product p,Account a\n" +
"where f.ProductID=? and f.AccountID=a.AccountID and f.ProductID=p.ProductID order by f.date desc";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Feedback fb = new Feedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7));
                listFeedback.add(fb);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listFeedback;
    }

    ;
    public void addFeedback(Feedback fb) {
        String sql = "insert into Feedback (AccountID, ProductID, scrip, date, rating) \n" +
        "values(?, ?, ?,GETDATE(),?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,fb.getAccountID() );
            stmt.setInt(2, fb.getProductID());
            stmt.setString(3, fb.getScript());
            stmt.setInt(4,fb.getRating());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
     public int avgRating(int productId) {

               String sql = "select AVG(Feedback.rating) from OrderDetails\n" +
                            "join Feedback\n" +
                            "on Feedback.ProductID = OrderDetails.ProductID\n" +
                            "where  OrderDetails.ProductID =? ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
                       
            }
        } catch (Exception e) {

        }
        return 0;
    }
     public int countReview(int id ){
         int review=0;
         String sql="select COUNT(AccountID)\n" +
"from Feedback\n" +
"where Feedback.ProductID=?";
         try {
             PreparedStatement stmt=connection.prepareStatement(sql);
             stmt.setInt(1, id);
            ResultSet rs= stmt.executeQuery();
             while (rs.next()) {                 
                 review=rs.getInt(1);
             }
         } catch (Exception e) {
         }
         
         return review;
     }
       public static void main(String[] args) {
 
            FeedbackDB dao = new FeedbackDB();
            Feedback fb = new Feedback(3, 7,"testrating",3);
            dao.addFeedback(fb);
            
            System.out.println( dao.avgRating(15));
//            List<Feedback> list = dao.getAllFeedback(6);
//                    for(Feedback o : list){
//                        System.out.println(o);
//                    }
             

         }  

    public int checkToFeedback(int accountId, int productId) {
        int x = 0;
        String sql = "select 1\n" +
                    "from OrderDetails\n" +
                    "JOIN Orders\n" +
                    "ON\n" +
                    "OrderDetails.OrderID = Orders.OrderID\n" +
                    "JOIN Account\n" +
                    "ON\n" +
                    "Orders.AccountID = Account.AccountID\n" +
                    "Where Account.AccountID = ? AND OrderDetails.ProductID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, accountId);
            stmt.setInt(2, productId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                x=(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return x;
    }
}
