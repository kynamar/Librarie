package dbmodels;
// Generated 21-Sep-2021 18:46:42 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Imprumuturi generated by hbm2java
 */
public class Imprumuturi  implements java.io.Serializable {


     private int id;
     private int idPersoane;
     private int idCarti;
     private Date dataImprumut;
     private Date dataReturnare;
     private String descriere;

    public Imprumuturi() {
    }

	
    public Imprumuturi(int id, int idPersoane, int idCarti, Date dataImprumut, Date dataReturnare) {
        this.id = id;
        this.idPersoane = idPersoane;
        this.idCarti = idCarti;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
    }
    public Imprumuturi(int id, int idPersoane, int idCarti, Date dataImprumut, Date dataReturnare, String descriere) {
       this.id = id;
       this.idPersoane = idPersoane;
       this.idCarti = idCarti;
       this.dataImprumut = dataImprumut;
       this.dataReturnare = dataReturnare;
       this.descriere = descriere;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getIdPersoane() {
        return this.idPersoane;
    }
    
    public void setIdPersoane(int idPersoane) {
        this.idPersoane = idPersoane;
    }
    public int getIdCarti() {
        return this.idCarti;
    }
    
    public void setIdCarti(int idCarti) {
        this.idCarti = idCarti;
    }
    public Date getDataImprumut() {
        return this.dataImprumut;
    }
    
    public void setDataImprumut(Date dataImprumut) {
        this.dataImprumut = dataImprumut;
    }
    public Date getDataReturnare() {
        return this.dataReturnare;
    }
    
    public void setDataReturnare(Date dataReturnare) {
        this.dataReturnare = dataReturnare;
    }
    public String getDescriere() {
        return this.descriere;
    }
    
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }




}


