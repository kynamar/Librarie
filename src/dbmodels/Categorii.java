package dbmodels;
// Generated 21-Sep-2021 18:46:42 by Hibernate Tools 4.3.1



/**
 * Categorii generated by hbm2java
 */
public class Categorii  implements java.io.Serializable {


     private int id;
     private String nume;
     private String descriere;

    public Categorii() {
    }

	
    public Categorii(int id) {
        this.id = id;
    }
    public Categorii(int id, String nume, String descriere) {
       this.id = id;
       this.nume = nume;
       this.descriere = descriere;
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
    public String getDescriere() {
        return this.descriere;
    }
    
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }




}


