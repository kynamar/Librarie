/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import librarievirtuala.Autor;

/**
 *
 * @author Andrei
 */
public interface AutoriRepository {
    boolean saveAutor(Autor autor);
    List<Autor> getAutori();
    Autor getAutor(int id);
    boolean removeAutor(Autor autor);
}
