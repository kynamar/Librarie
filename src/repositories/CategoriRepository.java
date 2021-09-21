/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import librarievirtuala.Categorie;

/**
 *
 * @author Andrei
 */
public interface CategoriRepository {
    boolean saveCategorie(Categorie categorie);
    List<Categorie> getCategori();
    Categorie getCategorie(int id);
    boolean removeCategorie(Categorie categorie);
}
