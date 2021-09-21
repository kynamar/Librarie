/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarievirtuala;

import java.util.Objects;

public class Categorie extends BusinessObjects {

    private static int id = 1;
    private String nume;
    private String descriere;

    public Categorie() {
        super(id++);
    }

    public Categorie(String nume, String descriere) {
        super(id++);
        this.nume = nume;
        this.descriere = descriere;
    }

    public Categorie(int id) {
        super(id);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Categorie{" + "nume=" + nume + ", descriere=" + descriere + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
