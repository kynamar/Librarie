package librarievirtuala;

import java.util.ArrayList;
import java.util.List;

public class Rand extends BusinessObjects {

    private List<Carte> carti;
    private Categorie categorie;
    private String nume;
    private static int id = 1;

    public Rand(Categorie categorie, String nume) {
        super(id++);
        this.carti = new ArrayList<>();
        this.categorie = categorie;
        this.nume = nume;
    }

    public Rand() {
        super(id++);
        this.carti = new ArrayList<>();
    }

    public Rand(int id) {
        super(id);
        this.carti = new ArrayList<>();
    }

    public List<Carte> getCarti() {
        return carti;
    }

    public void setCarti(List<Carte> carti) {
        this.carti = carti;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void addCarte(Carte carte) {
        if (!this.carti.contains(carte)) {
            carti.add(carte);
        } else {
            throw new RuntimeException("cartea introdusa este deja prezenta pe raft. Introduce-ti o alta.");
        }
    }

    public void removeCarte(Carte carte) {
        if (this.carti.contains(carte)) {
            carti.remove(carte);
        } else {
            throw new RuntimeException("cartea introdusa nu este prezenta pe raft. Introduce-ti o alta.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + super.getId();
        return hash;
    }

}
