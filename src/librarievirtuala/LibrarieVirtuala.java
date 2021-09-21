package librarievirtuala;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibrarieVirtuala {
    
    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("resorses/carti.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        List<Carte> carti = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Carte>>() {
        });
        Carte carte;
        jsonData = Files.readAllBytes(Paths.get("resorses/autori.json"));
        List<Autor> autori = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Autor>>() {
        });
        jsonData = Files.readAllBytes(Paths.get("resorses/editura.json"));
        List<Editura> edituri = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Editura>>() {
        });
        jsonData = Files.readAllBytes(Paths.get("resorses/categori.json"));
        List<Categorie> categori = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Categorie>>() {
        });
        jsonData = Files.readAllBytes(Paths.get("resorses/randuri.json"));
        List<Rand> randuri = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Rand>>() {
        });
        Rand rand = new Rand();
        jsonData = Files.readAllBytes(Paths.get("resorses/raft.json"));
        List<Raft> rafturi = objectMapper.readValue(jsonData, new TypeReference<ArrayList<Raft>>() {
        });
        carti.get(0).addAutor(autori.get(0));
        carti.get(1).addAutor(autori.get(0));
        carti.get(2).addAutor(autori.get(1));
        carti.get(0).setEditura(edituri.get(0));
        carti.get(1).setEditura(edituri.get(0));
        carti.get(2).setEditura(edituri.get(0));
        randuri.get(0).addCarte(carti.get(2));
        randuri.get(1).addCarte(carti.get(0));
        randuri.get(1).addCarte(carti.get(1));
        randuri.get(0).setCategorie(categori.get(0));
        randuri.get(1).setCategorie(categori.get(1));
        rafturi.get(0).getRanduri().add(new ArrayList<>());
        rafturi.get(0).getRanduri().get(0).add(randuri.get(0));
        rafturi.get(0).getRanduri().get(0).add(randuri.get(1));
        System.out.println("raftul: "+rafturi.get(0).getId() + " ," + rafturi.get(0).getNume() + " :");
        for (int i = 0; i < rafturi.get(0).getRanduri().size(); i++) {
            for (int j = 0; j < rafturi.get(0).getRanduri().get(i).size(); j++) {
                rand = rafturi.get(0).getRanduri().get(i).get(j);
                System.out.println("randul: "+rand.getId() + " ,coloana " + i + " ,linie " + j + " ," + rand.getNume() + " :");
                for (int n = 0; n < rafturi.get(0).getRanduri().get(i).get(j).getCarti().size(); n++) {
                    carte = rand.getCarti().get(n);
                    System.out.print("carte: "+carte.getId() + " ," + carte.getTitlu() + " ,");
                    if (carte.getAutori().size() > 1) {
                        System.out.print("Autori: ");
                        for (int m = 0; m < carte.getAutori().size(); m++) {
                            System.out.print(carte.getAutori().get(m).getAutor().getNume() + ","+carte.getAutori().get(m).getAutor().getId()+" ");
                        }
                        System.out.print(",");
                    } else {
                        if (carte.getAutori().size() == 1) {
                            System.out.print(carte.getAutori().get(0).getAutor().getNume() + " ,");
                        }
                    }
                    System.out.println(carte.getDescriere() + " ," + carte.getEditura().getNume() + " ," + carte.getIsbn() + " ," + carte.getPret());
                }
            }
        }
    }
    
}
