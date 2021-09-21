/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Categorie;
import repositories.CategoriRepository;

/**
 *
 * @author Andrei
 */
public class CategoriServiceImpl implements CategoriService {

    private static CategoriServiceImpl singleObject;

    private CategoriRepository categori;

    private CategoriServiceImpl() {
    }

    public static CategoriServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new CategoriServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveCategorie(Categorie categorie) {
        return categori.saveCategorie(categorie);
    }

    @Override
    public List<Categorie> getCategori() {
        return categori.getCategori();
    }

    @Override
    public Categorie getCategorie(int id) {
        return categori.getCategorie(id);
    }

    @Override
    public boolean removeCategorie(Categorie categorie) {
        return categori.removeCategorie(categorie);
    }

    @Override
    public void setCategoriRepository(CategoriRepository categoriRepository) {
        this.categori=categoriRepository;
    }

}
