package dbmodels;
// Generated 21-Sep-2021 18:46:42 by Hibernate Tools 4.3.1



/**
 * Abonamente generated by hbm2java
 */
public class Abonamente  implements java.io.Serializable {


     private int id;
     private String nume;
     private int durata;
     private int tip;
     private double pret;

    public Abonamente() {
    }

    public Abonamente(int id, String nume, int durata, int tip, double pret) {
       this.id = id;
       this.nume = nume;
       this.durata = durata;
       this.tip = tip;
       this.pret = pret;
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
    public int getDurata() {
        return this.durata;
    }
    
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public int getTip() {
        return this.tip;
    }
    
    public void setTip(int tip) {
        this.tip = tip;
    }
    public double getPret() {
        return this.pret;
    }
    
    public void setPret(double pret) {
        this.pret = pret;
    }




}

