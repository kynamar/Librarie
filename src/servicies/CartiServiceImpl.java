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
public class CartiServiceImpl implements CartiService {

    private static CartiServiceImpl singleObject;

    private CartiRepository ed;

    private CartiServiceImpl() {
    }

    public static CartiServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new CartiServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveCarte(Carte carte) {
        return ed.saveCarte(carte);
    }

    @Override
    public List<Carte> getCarti() {
        return ed.getCarti();
    }

    @Override
    public Carte getCarte(int id) {
        return ed.getCarte(id);
    }

    @Override
    public boolean removeCarte(Carte carte) {
        return ed.removeCarte(carte);
    }

    @Override
    public void setCarteRepository(CartiRepository cartiRepository) {
        this.ed = cartiRepository;
    }

}
