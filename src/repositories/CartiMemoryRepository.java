/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Carte;

/**
 *
 * @author Andrei
 */
public class CartiMemoryRepository implements CartiRepository {

    List<Carte> carti = new ArrayList<>();

    @Override
    public boolean saveCarte(Carte carte) {
        int index = carti.indexOf(carte);
        if (index == -1) {
            carti.add(carte);
            return true;
        }
        carti.set(index, carte);
        return true;
    }

    @Override
    public List<Carte> getCarti() {
        return carti;
    }

    @Override
    public Carte getCarte(int id) {
        int index = carti.indexOf(new Carte(id));
        if (index != -1) {
            return carti.get(index);
        }
        return null;
    }

    @Override
    public boolean removeCarte(Carte carte) {
        if (carti.contains(carte)) {
            carti.remove(carte);
            return true;
        }
        return false;
    }

}
