/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import librarievirtuala.Autor;

/**
 *
 * @author Andrei
 */
public class AutoriMemoryRepository implements AutoriRepository{
    List<Autor> autori=new ArrayList<>();
    @Override
    public boolean saveAutor(Autor autor) {
        int index=autori.indexOf(autor);
        if(index==-1){
            autori.add(autor);
            return true;
        }
        autori.set(index, autor);
        return true;
    }

    @Override
    public List<Autor> getAutori() {
    return autori;    
    }

    @Override
    public Autor getAutor(int id) {
        int index=autori.indexOf(new Autor(id));
        if(index!=-1){
            return autori.get(index);
        }
        return null;
    }

    @Override
    public boolean removeAutor(Autor autor) {
       if(autori.contains(autor)){
           autori.remove(autor);
           return true;
       }
       return false;
    }
    
}
