/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Rand;
import repositories.RanduriRepository;

/**
 *
 * @author Andrei
 */
public class RanduriServiceImpl implements RanduriService {

    private static RanduriServiceImpl singleObject;

    private RanduriRepository ed;

    private RanduriServiceImpl() {
    }

    public static RanduriServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new RanduriServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveRand(Rand rand) {
        return ed.saveRand(rand);
    }

    @Override
    public List<Rand> getRanduri() {
        return ed.getRanduri();
    }

    @Override
    public Rand getRand(int id) {
        return ed.getRand(id);
    }

    @Override
    public boolean removeRand(Rand rand) {
        return ed.removeRand(rand);
    }

    @Override
    public void setRandRepository(RanduriRepository randuriRepository) {
        this.ed = randuriRepository;
    }

}
