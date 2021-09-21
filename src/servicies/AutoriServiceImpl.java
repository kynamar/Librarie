/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicies;

import java.util.List;
import librarievirtuala.Autor;
import repositories.AutoriRepository;

/**
 *
 * @author Andrei
 */
public class AutoriServiceImpl implements AutoriService {

    private static AutoriServiceImpl singleObject;

    private AutoriRepository ed;

    private AutoriServiceImpl() {
    }

    public static AutoriServiceImpl getInstance() {
        if (singleObject == null) {
            singleObject = new AutoriServiceImpl();
        }
        return singleObject;
    }

    @Override
    public boolean saveAutor(Autor autor) {
        return ed.saveAutor(autor);
    }

    @Override
    public List<Autor> getAutori() {
        return ed.getAutori();
    }

    @Override
    public Autor getAutor(int id) {
        return ed.getAutor(id);
    }

    @Override
    public boolean removeAutor(Autor autor) {
        return ed.removeAutor(autor);
    }

    @Override
    public void setAutorRepository(AutoriRepository autoriRepository) {
        this.ed = autoriRepository;
    }

}
