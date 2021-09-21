/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public interface EdituriRepository {
    boolean saveEditura(Editura editura);
    List<Editura> getEdituri();
    Editura getEditura(int id);
    boolean removeEditura(Editura editura);
}
