
package Models;

import java.sql.Date;


public class Order {
    private String idOrder;
    private int idAccount;
    private String date;
    private double price;
    private int idStore;
    private String address;
    private int status;
    private int idShipper;
    private int method;

    public Order() {
    }

    public Order(String idOrder, int idAccount, String date, double price, int idStore, String address,int status,int idShipper,int method) {
        this.idOrder = idOrder;
        this.idAccount = idAccount;
        this.date = date;
        this.price = price;
        this.idStore = idStore;
        this.address = address;
        this.status=status;
        this.idShipper=idShipper;
        this.method=method;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    
    
    public int getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }


    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idAccount=" + idAccount + ", date=" + date + ", price=" + price + ", idStore=" + idStore + ", address=" + address + '}';
    }

   
    
    
}
