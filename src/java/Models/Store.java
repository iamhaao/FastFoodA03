
package Models;


public class Store {
    private int idStore;
    private String name;
    private String address;

    public Store() {
    }

    public Store(int idStore, String name, String address) {
        this.idStore = idStore;
        this.name = name;
        this.address = address;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Store{" + "idStore=" + idStore + ", name=" + name + ", address=" + address + '}';
    }
    
    
}
