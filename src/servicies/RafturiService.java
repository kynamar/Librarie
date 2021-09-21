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
public interface RafturiService {
     boolean saveRaft(Raft raft);
    List<Raft> getRafturi();
    Raft getRaft(int id);
    boolean removeRaft(Raft raft);
    void setRaftRepository(RafturiRepository rafturiRepository);
}
