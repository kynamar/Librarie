/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Rand;

/**
 *
 * @author Andrei
 */
public class RanduriMemoryRepository implements RanduriRepository {

    List<Rand> randuri = new ArrayList<>();

    @Override
    public boolean saveRand(Rand rand) {
        int index = randuri.indexOf(rand);
        if (index == -1) {
            randuri.add(rand);
            return true;
        }
        randuri.set(index, rand);
        return true;
    }

    @Override
    public List<Rand> getRanduri() {
        return randuri;
    }

    @Override
    public boolean removeRand(Rand rand) {
        if (randuri.contains(rand)) {
            randuri.remove(rand);
            return true;
        }
        return false;
    }

    @Override
    public Rand getRand(int id) {
        int index = randuri.indexOf(new Rand(id));
        if (index != -1) {
            return randuri.get(index);
        }
        return null;
    }

}
