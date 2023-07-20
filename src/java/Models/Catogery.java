
package Models;


public class Catogery {
    private int idCatory;
    private String name;
    private String description;

    public Catogery() {
    }

    public Catogery(int idCatory, String name, String description) {
        this.idCatory = idCatory;
        this.name = name;
        this.description = description;
    }

    public int getIdCatory() {
        return idCatory;
    }

    public void setIdCatory(int idCatory) {
        this.idCatory = idCatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Catogert{" + "idCatory=" + idCatory + ", name=" + name + ", description=" + description + '}';
    }
    
    
}
