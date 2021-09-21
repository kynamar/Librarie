package librarievirtuala;

import java.util.ArrayList;
import java.util.List;

public class Carte extends BusinessObjects {

    private static int id = 1;
    private String isbn;
    private String titlu;
    private String descriere;
    private Double pret;
    private Editura editura;
    private List<CarteAutor> autori;

    public Carte() {
        super(id++);
        this.autori = new ArrayList<>();
    }

    public Carte(int id) {
        super(id);
        this.autori = new ArrayList<>();
    }

    public Carte(String isbn, String titlu, String descriere, Double pret) {
        super(id++);
        this.isbn = isbn;
        this.titlu = titlu;
        this.descriere = descriere;
        this.pret = pret;
        this.autori = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public void addAutor(Autor autor) {
        CarteAutor a = new CarteAutor(this, autor);
        //a.setId(this.getId());
        autori.add(a);
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public List<CarteAutor> getAutori() {
        return autori;
    }

    public Editura getEditura() {
        return editura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }
}
