
package Models;

import java.util.Date;


public class Cart extends Product{
    private int quantityProduct;

    public Cart() {
    }

    public Cart(int quantityProduct, int idProduct, String name, String description, double price, String image,int idCatory, int quantiry,String createdAt) {
        super(idProduct, name, description, price, image, idCatory, quantiry,createdAt);
        this.quantityProduct = quantityProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
    
    
}
