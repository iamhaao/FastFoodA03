/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Catogery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO
 */
public class CatogeryDB extends DBContext{
    
    
    public List<Catogery> getAll(){
        String sql="select * from Category";
        List <Catogery> listCatogery=new ArrayList<>();
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {                
                Catogery c=new Catogery(rs.getInt(1), rs.getString(2), rs.getString(3));
                listCatogery.add(c);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCatogery;
    }
    
    public static void main(String[] args) {
         CatogeryDB cdb=new CatogeryDB();
        List<Catogery> products=cdb.getAll();
        for (Catogery product : products) {
            System.out.println(product.toString()); 
        }
    }

    public String getCatoryById(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
