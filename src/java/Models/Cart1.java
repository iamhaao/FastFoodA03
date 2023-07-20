
package Models;


public class Cart1 {
    private String idCart;
    private int idAccount;

    public Cart1() {
    }

    public Cart1(String idCart, int idAccount) {
        this.idCart = idCart;
        this.idAccount = idAccount;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "Cart1{" + "idCart=" + idCart + ", idAccount=" + idAccount + '}';
    }
    
    
}
