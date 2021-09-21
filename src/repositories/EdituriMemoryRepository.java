/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public class EdituriMemoryRepository implements EdituriRepository {

    private final List<Editura> edituri = new ArrayList<>();

    public EdituriMemoryRepository() {
      
    }
    
    
    

    @Override
    public boolean saveEditura(Editura editura) {
        int index = edituri.indexOf(editura);
        System.out.println(index+" am gasit index");
        if (index == -1) {
            edituri.add(editura);
            return true;
        }
        edituri.set(index, editura);
        return true;
    }

    @Override
    public List<Editura> getEdituri() {
        return edituri;
    }

    @Override
    public Editura getEditura(int id) {
        int index = edituri.indexOf(new Editura(id));
        if (index != -1) {
            return edituri.get(index);
        }
        return null;
    }

    @Override
    public boolean removeEditura(Editura editura) {
        if (edituri.contains(editura)) {
            edituri.remove(editura);
            return true;
        }
        return false;
    }

}
