/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import librarievirtuala.Raft;

/**
 *
 * @author Andrei
 */
public interface RafturiRepository {
    boolean saveRaft(Raft raft);
    List<Raft> getRafturi();
    Raft getRaft(int id);
    boolean removeRaft(Raft raft);
}
