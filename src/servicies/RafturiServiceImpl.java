/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Raft;
import repositories.RafturiRepository;

/**
 *
 * @author Andrei
 */
public class RafturiServiceImpl implements RafturiService {

    private static RafturiServiceImpl singleObject;

    private RafturiRepository ed;

    private RafturiServiceImpl() {
    }

    public static RafturiServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new RafturiServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveRaft(Raft raft) {
        return ed.saveRaft(raft);
    }

    @Override
    public List<Raft> getRafturi() {
        return ed.getRafturi();
    }

    @Override
    public Raft getRaft(int id) {
        return ed.getRaft(id);
    }

    @Override
    public boolean removeRaft(Raft raft) {
        return ed.removeRaft(raft);
    }

    @Override
    public void setRaftRepository(RafturiRepository rafturiRepository) {
        this.ed = rafturiRepository;
    }

}
