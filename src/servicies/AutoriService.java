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
public interface AutoriService {
     boolean saveAutor(Autor autor);
    List<Autor> getAutori();
    Autor getAutor(int id);
    boolean removeAutor(Autor autor);
    void setAutorRepository(AutoriRepository autoriRepository);
}
