
package librarievirtuala;


public class CarteAutor extends BusinessObjects{
    private Carte carte;
    private Autor autor;
    public CarteAutor(Carte carte, Autor autor) {
        super(0);
        this.carte=carte;
        this.autor=autor;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
        
}
