/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Categorie;

/**
 *
 * @author Andrei
 */
public class CategoriMemoryRepository implements CategoriRepository {

    List<Categorie> categori = new ArrayList<>();

    @Override
    public boolean saveCategorie(Categorie categorie) {
        int index = categori.indexOf(categorie);
        if (index == -1) {
            categori.add(categorie);
            return true;
        }
        categori.set(index, categorie);
        return true;
    }

    @Override
    public List<Categorie> getCategori() {
        return categori;
    }

    @Override
    public Categorie getCategorie(int id) {
        int index = categori.indexOf(new Categorie(id));
        if (index != -1) {
            return categori.get(index);
        }
        return null;
    }

    @Override
    public boolean removeCategorie(Categorie categorie) {
        if (categori.contains(categorie)) {
            categori.remove(categorie);
            return true;
        }
        return false;
    }
}
