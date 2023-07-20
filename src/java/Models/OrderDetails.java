package Models;

import DAO.DBContext;
import java.sql.PreparedStatement;
import java.util.Date;

public class OrderDetails extends Product {

    private String idOrder;
    private int quantityProduct;
    private double priceDetails;

    public OrderDetails() {
    }

    public OrderDetails(String idOrder, int quantity, double priceDetails) {
        this.idOrder = idOrder;
        this.quantityProduct = quantity;
        this.priceDetails = priceDetails;
    }

    public OrderDetails(String idOrder, int quantity, double priceDetails, int idProduct, String name, String description, double price, String image, int idCatory, int quantiry, String createdAt) {
        super(idProduct, name, description, price, image, idCatory, quantiry, createdAt);
        this.idOrder = idOrder;
        this.quantityProduct = quantity;
        this.priceDetails = priceDetails;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getquantityProduct() {
        return quantityProduct;
    }

    public void quantityProduct(int quantity) {
        this.quantityProduct = quantity;
    }

    public double getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(double priceDetails) {
        this.priceDetails = priceDetails;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "idOrder=" + idOrder + ", quantityProduct=" + quantityProduct + ", priceDetails=" + priceDetails + '}';
    }


}
