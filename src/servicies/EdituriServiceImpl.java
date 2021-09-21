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
public class EdituriServiceImpl implements EdituriService {

    private static EdituriServiceImpl singleObject;

    private EdituriRepository ed;

    private EdituriServiceImpl() {
    }
    
    

    public static EdituriServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new EdituriServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveEditura(Editura editura) {
        return ed.saveEditura(editura);
    }

    @Override
    public List<Editura> getEdituri() {
        return ed.getEdituri();
    }

    @Override
    public Editura getEditura(int id) {
        return ed.getEditura(id);
    }

    @Override
    public boolean removeEditura(Editura editura) {
        return ed.removeEditura(editura);
    }

    @Override
    public void setEdituraRepository(EdituriRepository edituriRepository) {
        this.ed = edituriRepository;
    }

}
