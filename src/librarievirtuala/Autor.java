/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarievirtuala;

import java.util.ArrayList;
import java.util.List;


public class Autor extends BusinessObjects{
    private static int id=1;
    private String nume;
    private int anulNasteri;
    private List<CarteAutor> carti;

    public Autor() {
        super(id++);
        carti=new ArrayList<>();
    }
    public Autor(int id) {
        super(id);
        carti=new ArrayList<>();
    }

    public Autor(String nume, int anulNasteri) {
        super(id++);
        this.nume = nume;
        this.anulNasteri = anulNasteri;
        carti=new ArrayList<>();
    }

    public void addCarte(Carte carte) {
        CarteAutor a=new CarteAutor(carte, this);
        a.setId(this.getId());
        carti.add(a);
    }
    

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAnulNasteri() {
        return anulNasteri;
    }

    public void setAnulNasteri(int anulNasteri) {
        this.anulNasteri = anulNasteri;
    }

    public List<CarteAutor> getCarti() {
        return carti;
    }
    
}
