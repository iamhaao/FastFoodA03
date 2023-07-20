
package Models;


public class OrderManage extends Order{
    private String username;
    private String name;
    private String store;
    private String phone;
    private String shipper;

    public OrderManage() {
    }

    public OrderManage(String username, String name, String store, String phone,  String idOrder, int idAccount, String date, double price, int idStore, String address, int status, int idShipper, int method,String shipper) {
        super(idOrder, idAccount, date, price, idStore, address, status, idShipper, method);
        this.username = username;
        this.name = name;
        this.store = store;
        this.phone = phone;
        this.shipper = shipper;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    @Override
    public String toString() {
        return "OrderManage{" + "username=" + username + ", name=" + name + ", store=" + store + ", phone=" + phone + ", shipper=" + shipper + '}';
    }

   
    
    
}
