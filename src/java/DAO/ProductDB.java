/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Cart;
import Models.Product;
import Models.ProductInStore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO
 */
public class ProductDB extends DBContext {

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product order by CreatedAt desc ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    ;
   

    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product where Name LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }

    ;
     public int getTotaProduct() {
        String sql = "select count(*) from Product where Quantity=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product where Quantity=? and  order by ProductID offset ? rows fetch next 6 rows only";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, (index - 1) * 6);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                products.add(p);

            }
        } catch (Exception e) {
        }
        return products;
    }

    public List<Product> getProductByType(int id, int index) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product  ";
        if (id == 0) {
            sql += "where Quantity=1 order by ProductID offset " + ((index - 1) * 8) + " rows fetch next 8 rows only";
        } else {
            sql += " where CategoryId=" + id + "order by CreatedAt desc";
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    ;
    
    
    public Product getProductByID(int id) {
        String sql = "select * from Product Where ProductID=?";
        Product p = new Product();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setIdProduct(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setImage(rs.getString(5));
                p.setIdCatory(rs.getInt(6));
                p.setQuantity(rs.getInt(7));
                p.setCreatedAt(rs.getString(8));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> list) {
        List<Cart> listCart = new ArrayList<>();
        try {
            if (!list.isEmpty()) {
                for (Cart cart : list) {
                    String sql = "select * from Product where ProductID=? order by CreatedAt desc";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setInt(1, cart.getIdProduct());
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setIdProduct(rs.getInt(1));
                        row.setName(rs.getString(2));
                        row.setDescription(rs.getString(3));
                        row.setPrice(rs.getDouble(4));
                        row.setImage(rs.getString(5));
                        row.setIdCatory(rs.getInt(6));
                        row.setQuantity(rs.getInt(7));
                        row.setCreatedAt(rs.getString(8));
                        row.setQuantityProduct(cart.getQuantityProduct());
                        listCart.add(row);
                    }
                }
            }
        } catch (Exception e) {
        }
        return listCart;
    }



    public double getTotalMoney(ArrayList<Cart> list) throws SQLException {
        double sum = 0;
        if (!list.isEmpty()) {
            for (Cart c : list) {
                String sql = "Select price from Product where ProductID=?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, c.getIdProduct());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    sum += rs.getDouble(1) * c.getQuantityProduct();
                }
            }
        }
        return sum;
    }

    public List<Product> bestSeller() {
        ArrayList<Product> bestseller = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "execute bestseller";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            for (Integer integer : list) {
                ProductDB pdb = new ProductDB();
                Product p = pdb.getProductByID(integer);
                bestseller.add(p);
            }
        } catch (Exception e) {
        }
        return bestseller;
    }

    public void addProduct(Product p) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([Name]\n"
                + "           ,[Description]\n"
                + "           ,[Price]\n"
                + "           ,[Image]\n"
                + "           ,[CategoryId]\n"
                + "           ,[Quantity]\n"
                + "           ,[CreatedAt])\n"
                + "     VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPrice());
            stmt.setString(4, p.getImage());
            stmt.setInt(5, p.getIdCatory());
            stmt.setInt(6, p.getQuantity());
            stmt.setString(7, p.getCreatedAt());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> newProducts() {
        String sql = "execute newproduct";
        ArrayList<Product> newproduct = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            for (Integer integer : list) {
                ProductDB pdb = new ProductDB();
                Product p = pdb.getProductByID(integer);
                newproduct.add(p);
            }
        } catch (Exception e) {
        }
        return newproduct;
    }

    public void deleteProduct(int id) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [Quantity] = ?\n"
                + " WHERE ProductID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 0);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
        } finally {
        }
    }

    public void updateProduct(Product p) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[CategoryId] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[CreatedAt] = ?\n"
                + " WHERE ProductID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPrice());
            stmt.setString(4, p.getImage());
            stmt.setInt(5, p.getIdCatory());
            stmt.setInt(6, p.getQuantity());
            stmt.setString(7, p.getCreatedAt());
            stmt.setInt(8, p.getIdProduct());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int quantityProductOfStore(int idStore,int idproduct){
        int quantity = 0;
        String sql="select quantity from WareHouse where ProductID=? and StoreID=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, idproduct);
            stmt.setInt(2, idStore);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                quantity=rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return quantity;
    }
    
    
    public List<ProductInStore> getAllPByStore(int StoreID, int index) {
        List<ProductInStore> productInStores = new ArrayList<>();
        String sql = "SELECT Product.Name, Product.ProductID,Product.Image, WareHouse.quantity,Store.StoreID\n"
                + "FROM Product\n"
                + "JOIN \n"
                + "WareHouse\n"
                + "ON Product.ProductID = WareHouse.ProductID\n"
                + "JOIN Store\n"
                + "ON Store.StoreID = WareHouse.StoreID\n"
                + "WHERE Store.StoreID = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, StoreID);
//            stmt.setInt(2, index);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductInStore pInStore = new ProductInStore(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                ;
                productInStores.add(pInStore);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productInStores;
    }

    public int getTotaProductInStore(String storeID) {
        int x = 0;
        String sql = "SELECT COUNT(*)\n"
                + "FROM Product\n"
                + "JOIN \n"
                + "WareHouse\n"
                + "ON Product.ProductID = WareHouse.ProductID\n"
                + "JOIN Store\n"
                + "ON Store.StoreID = WareHouse.StoreID\n"
                + "WHERE Store.StoreID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, storeID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return x = rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return x;
    }

    public void updateProductInStore(int quantity, int productID, int storeID) {
        String sql = "Update WareHouse set quantity = ? where ProductID = ? and StoreID =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, quantity);
            stmt.setInt(2, productID);
            stmt.setInt(3, storeID);

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ProductInStore getProductByIDInStore(int id) {
        String sql = "With productInStore\n" +
                        "as(\n" +
                        "SELECT Product.Name, Product.ProductID ,Product.Image, WareHouse.quantity,Store.StoreID\n" +
                        "FROM Product\n" +
                        "JOIN \n" +
                        "WareHouse\n" +
                        "ON Product.ProductID = WareHouse.ProductID\n" +
                        "JOIN Store\n" +
                        "ON Store.StoreID = WareHouse.StoreID\n" +
                        "WHERE Store.StoreID = 1 )\n" +
                        "select * from productInStore where ProductID = ?";
        ProductInStore p = new ProductInStore();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setNameProduct(rs.getString(1));
                p.setProductID(rs.getString(2));
                p.setImage(rs.getString(3));
                p.setStoreID(rs.getString(5));
                p.setQuantity(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }
 public void deleteProductInStore(int productID,int StoreID) {
        String sql = "delete WareHouse where ProductID =? and StoreID =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, productID);
                        stmt.setInt(2, StoreID);

            stmt.executeUpdate();
        } catch (Exception e) {
        } finally {
        }
    }
        public static void main(String[] args) {
        ProductDB pdb = new ProductDB();
        int quantity=pdb.quantityProductOfStore(1, 21);
         System.out.println(quantity);
//        List<Product> products = pdb.getProductByType(3, 0);
//        for (Product product : products) {
//            System.out.println(product);
//        }
    }
}
