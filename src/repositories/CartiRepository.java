/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import librarievirtuala.Carte;

/**
 *
 * @author Andrei
 */
public interface CartiRepository {
    boolean saveCarte(Carte carte);
    List<Carte> getCarti();
    Carte getCarte(int id);
    boolean removeCarte(Carte carte);
}
