/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Editura;
import repositories.EdituriRepository;

/**
 *
 * @author Andrei
 */
public interface EdituriService {
    boolean saveEditura(Editura editura);
    List<Editura> getEdituri();
    Editura getEditura(int id);
    boolean removeEditura(Editura editura);
    void setEdituraRepository(EdituriRepository edituriRepository);
}
