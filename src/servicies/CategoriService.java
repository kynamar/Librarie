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
public interface CategoriService {
    boolean saveCategorie(Categorie categorie);
    List<Categorie> getCategori();
    Categorie getCategorie(int id);
    boolean removeCategorie(Categorie categorie);
    void setCategoriRepository(CategoriRepository categoriRepository);
}
