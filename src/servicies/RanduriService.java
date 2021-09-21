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
public interface RanduriService {
     boolean saveRand(Rand rand);
    List<Rand> getRanduri();
    Rand getRand(int id);
    boolean removeRand(Rand rand);
    void setRandRepository(RanduriRepository randuriRepository);
}
