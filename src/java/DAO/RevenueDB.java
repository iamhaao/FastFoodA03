/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBContext.connection;
import Models.Product;
import Models.Revenue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RevenueDB extends DBContext{
    
    
     public List<Revenue> getAllRevenue(int storeId, String year) {
        List<Revenue> revenues = new ArrayList<>();
        String sql =    " WITH REVENUE AS\n" +
                    "(\n" +
                    "select\n" +
                    "	YEAR(OrderDate) as YEAR,\n" +
                    "	FORMAT(OrderDate,'MMMM') as MONTH,\n" +
                    "	FORMAT(OrderDate, 'MMMM/yyyy') AS ORDERDATE,\n" +
                    "	SUM(TotalAmount) as TOTAL_REVENUE,\n" +
                    "	COUNT(OrderDate) as TIMES_ORDER\n" +
                    "from orders \n" +
                    "WHERE STOREID  =? AND status = 2\n" +
                    "GROUP BY FORMAT(OrderDate,'MMMM'),YEAR(OrderDate),FORMAT(OrderDate, 'MMMM/yyyy')\n" +
                    ")\n" +
                    "\n" +
                    "select YEAR,MONTH,ORDERDATE,TIMES_ORDER,TOTAL_REVENUE,cast((total_revenue *100/1500000) as  DECIMAL(6,2)) as PERSENT \n" +
                    "from REVENUE \n" +
                    "WHERE YEAR =?";
                    
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, storeId);
            stmt.setString(2,year );

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Revenue r = new Revenue(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getDouble(6) );
                revenues.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return revenues;
    };
        public List<Product> bestPRevenueY() {
        List<Product> listP = new ArrayList<>();
        String sql = "WITH bestSeller as\n"
                + "(\n"
                + "select ProductID,YEAR(OrderDate) as Year,sum(Quantity) as totalPbestOrder\n"
                + "from OrderDetails\n"
                + "JOIN Orders\n"
                + "ON Orders.OrderID = OrderDetails.OrderID\n"
                + "group by ProductID,YEAR(OrderDate)\n"
                + ")\n"
                + "select top 8 p.Name,\n"
                + "p.Price* totalPbestOrder as totalRevenue,\n"
                + "totalPbestOrder from  bestSeller\n"
                + "JOIN Product as p\n"
                + "ON p.ProductID = bestSeller.ProductID\n"
                + "order by totalPbestOrder desc";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getDouble(2),
                        rs.getInt(3));
                listP.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listP;
    }

    ;
                         ;
        public List<Product> bestPRevenue(int storeId, String year) {
        List<Product> listP = new ArrayList<>();
        String sql = "WITH bestSeller as\n"
                + "(\n"
                + "select ProductID,YEAR(OrderDate) as Year,sum(Quantity) as totalPbestOrder\n"
                + "from OrderDetails\n"
                + "JOIN Orders\n"
                + "ON Orders.OrderID = OrderDetails.OrderID\n"
                + "WHERE Orders.StoreID =?\n"
                + "group by ProductID,YEAR(OrderDate)\n"
                + ")\n"
                + "select top 8 p.Name,\n"
                + "p.Price* totalPbestOrder as totalRevenue,\n"
                + "totalPbestOrder from  bestSeller\n"
                + "JOIN Product as p\n"
                + "ON p.ProductID = bestSeller.ProductID where YEAR =?\n"
                + "order by totalPbestOrder desc";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setInt(1, storeId);

             stmt.setString(2, year);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getDouble(2),
                        rs.getInt(3));
                listP.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listP;
    }

    ;
          public List<Revenue> getAllRevenueAllStrore( String year) {
        List<Revenue> revenues = new ArrayList<>();
        String sql =    " WITH REVENUE AS\n" +
                    "(\n" +
                    "select\n" +
                    "	YEAR(OrderDate) as YEAR,\n" +
                    "	FORMAT(OrderDate,'MMMM') as MONTH,\n" +
                    "	FORMAT(OrderDate, 'MMMM/yyyy') AS ORDERDATE,\n" +
                    "	SUM(TotalAmount) as TOTAL_REVENUE,\n" +
                    "	COUNT(OrderDate) as TIMES_ORDER\n" +
                    "from orders WHERE status = 2 \n" +
                    "GROUP BY FORMAT(OrderDate,'MMMM'),YEAR(OrderDate),FORMAT(OrderDate, 'MMMM/yyyy')\n" +
                    ")\n" +
                    "\n" +
                    "select YEAR,MONTH,ORDERDATE,TIMES_ORDER,TOTAL_REVENUE,cast((total_revenue *100/1500000) as  DECIMAL(6,2)) as PERSENT \n" +
                    "from REVENUE \n" +
                    "WHERE YEAR =?";
                    
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,year );



            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Revenue r = new Revenue(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getDouble(6) );
                revenues.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return revenues;
    };
          
        public List<Revenue> getAllRevenueYear( ) {
        List<Revenue> revenues = new ArrayList<>();
        String sql =    " WITH REVENUE AS\n" +
                        "(\n" +
                        "select\n" +
                        "	YEAR(OrderDate) as YEAR,\n" +
                        "	SUM(TotalAmount) as TOTAL_REVENUE,\n" +
                        "	COUNT(OrderDate) as TIMES_ORDER\n" +
                        "from orders WHERE status = 2 \n" +
                        "GROUP BY YEAR(OrderDate)\n" +
                        ")\n" +
                        "select YEAR,TIMES_ORDER,TOTAL_REVENUE\n" +
                        "from REVENUE ";
                    
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Revenue r = new Revenue(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3));
                revenues.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return revenues;
    }

    ;
         public List<Revenue> getAllAvRevenueYear(String year ) {
        List<Revenue> revenues = new ArrayList<>();
        String sql =    " WITH REVENUE AS\n" +
                    "(\n" +
                    "select\n" +
                    "	YEAR(OrderDate) as YEAR,\n" +
                    "	FORMAT(OrderDate,'MMMM') as MONTH,\n" +
                    "	FORMAT(OrderDate, 'MMMM/yyyy') AS ORDERDATE,\n" +
                    "	SUM(TotalAmount) as TOTAL_REVENUE,\n" +
                    "	COUNT(OrderDate) as TIMES_ORDER\n" +
                    "from orders WHERE status = 2 \n" +
                    "GROUP BY FORMAT(OrderDate,'MMMM'),YEAR(OrderDate),FORMAT(OrderDate, 'MMMM/yyyy')\n" +
                    ")\n" +
                    "\n" +
                    "select YEAR,TIMES_ORDER,total_revenue/3 as Av \n" +
                    "from REVENUE \n" +
                    "WHERE YEAR =?";
                    
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,year );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Revenue r = new Revenue(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3));
                revenues.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return revenues;
    }

    ;
        public static void main(String[] args) {
            RevenueDB rdb = new RevenueDB();
            List<Revenue> revenues =rdb.getAllRevenueAllStrore("2023");
            for (Revenue revenue : revenues) {
                System.out.println(revenue);
            }


        }
    
}
