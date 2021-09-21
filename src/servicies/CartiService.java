/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Carte;
import repositories.CartiRepository;

/**
 *
 * @author Andrei
 */
public interface CartiService {
     boolean saveCarte(Carte carte);
    List<Carte> getCarti();
    Carte getCarte(int id);
    boolean removeCarte(Carte carte);
    void setCarteRepository(CartiRepository cartiRepository);
}
