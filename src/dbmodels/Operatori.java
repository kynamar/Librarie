package dbmodels;
// Generated 21-Sep-2021 18:46:42 by Hibernate Tools 4.3.1



/**
 * Operatori generated by hbm2java
 */
public class Operatori  implements java.io.Serializable {


     private int id;
     private String nume;
     private String parola;
     private int idPersoane;
     private boolean activ;

    public Operatori() {
    }

    public Operatori(int id, String nume, String parola, int idPersoane, boolean activ) {
       this.id = id;
       this.nume = nume;
       this.parola = parola;
       this.idPersoane = idPersoane;
       this.activ = activ;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNume() {
        return this.nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getParola() {
        return this.parola;
    }
    
    public void setParola(String parola) {
        this.parola = parola;
    }
    public int getIdPersoane() {
        return this.idPersoane;
    }
    
    public void setIdPersoane(int idPersoane) {
        this.idPersoane = idPersoane;
    }
    public boolean isActiv() {
        return this.activ;
    }
    
    public void setActiv(boolean activ) {
        this.activ = activ;
    }




}

