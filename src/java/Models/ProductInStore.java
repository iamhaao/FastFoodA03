
package Models;

public class ProductInStore {
    private String nameProduct;
    private String productID;
     private String image;
    private String quantity;
    private String storeID;

    public ProductInStore(String nameProduct, String productID, String image, String quantity, String storeID) {
        this.nameProduct = nameProduct;
        this.productID = productID;
        this.image = image;
        this.quantity = quantity;
        this.storeID = storeID;
    }

  
    public ProductInStore() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductInStore{" + "nameProduct=" + nameProduct + ", productID=" + productID + ", image=" + image + ", quantity=" + quantity + ", storeID=" + storeID + '}';
    }


    
    
}