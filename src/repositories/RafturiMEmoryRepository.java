/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Raft;

/**
 *
 * @author Andrei
 */
public class RafturiMEmoryRepository implements RafturiRepository {

    List<Raft> rafturi = new ArrayList<>();

    @Override
    public boolean saveRaft(Raft raft) {
        int index = rafturi.indexOf(raft);
        if (index == -1) {
            rafturi.add(raft);
            return true;
        }
        rafturi.set(index, raft);
        return true;
    }

    @Override
    public List<Raft> getRafturi() {
        return rafturi;
    }

    @Override
    public Raft getRaft(int id) {
        int index = rafturi.indexOf(new Raft(id));
        if (index != -1) {
            return rafturi.get(index);
        }
        return null;
    }

    @Override
    public boolean removeRaft(Raft raft) {
        if (rafturi.contains(raft)) {
            rafturi.remove(raft);
            return true;
        }
        return false;
    }

}
