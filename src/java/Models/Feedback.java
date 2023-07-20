/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author LENOVO
 */
public class Feedback {
    private int accountID; 
    private int productID; 
    private String name;
    private String avatar;
    private String script; 
    private String date; 
    private int rating; 

    public Feedback(int accountID, int productID, String name, String avatar, String script, String date, int rating) {
        this.accountID = accountID;
        this.productID = productID;
        this.name = name;
        this.avatar = avatar;
        this.script = script;
        this.date = date;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    public Feedback(int accountID, int productID, String script, int rating) {
        this.accountID = accountID;
        this.productID = productID;
        this.script = script;
        this.rating = rating;
    }

   

    public Feedback() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" + "accountID=" + accountID + ", productID=" + productID + ", script=" + script + ", date=" + date + ", rating=" + rating + '}';
    }

   
    
}
