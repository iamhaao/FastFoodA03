
package Models;


public class JobApply {
    private int idAccount;
    private String email;
    private String cv;
    private int status;

    public JobApply() {
    }

    public JobApply(int idAccount, String email, String cv, int status) {
        this.idAccount = idAccount;
        this.email = email;
        this.cv = cv;
        this.status = status;
    }



    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApply{" + "idAccount=" + idAccount + ", email=" + email + ", cv=" + cv + ", status=" + status + '}';
    }
    
    
    
}
