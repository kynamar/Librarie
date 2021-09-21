package librarievirtuala;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Raft extends BusinessObjects {

    private List<List<Rand>> randuri;
    private String nume;
    private int linieMax;
    private int coloanaMax;
    private int linieCurenta = 0;
    private int coloanaCurenta = 0;
    private static int id = 1;

    public Raft() {
        super(id++);
        randuri = new ArrayList<>();
    }

    public Raft(int id) {
        super(id);
        randuri = new ArrayList<>();
    }

    public Raft(String nume, int coloanaMax, int linieMax) {
        super(id++);
        this.nume = nume;
        this.coloanaMax = coloanaMax;
        this.linieMax = linieMax;
        randuri = new ArrayList<>(coloanaMax);
        for (int i = 0; i < coloanaMax; i++) {
            randuri.add(new ArrayList<>(linieMax));
        }
    }

    public List<List<Rand>> getRanduri() {
        return randuri;
    }

    public void setRanduri(List<List<Rand>> randuri) {
        this.randuri = randuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getColoanaMax() {
        return coloanaMax;
    }

    public void setColoanaMax(int coloanaMax) {
        this.coloanaMax = coloanaMax;
    }

    public int getLinieMax() {
        return linieMax;
    }

    public void setLinieMax(int linieMax) {
        this.linieMax = linieMax;
    }

    public void addRandAtPosition(int coloana, int linie, Rand rand) {
        if (coloanaMax >= coloana && linieMax >= linie) {
            randuri.get(coloana).add(linie, rand);
        } else {
            throw new RuntimeException("Datele introduse depasesc capacitatea raftului");
        }
    }

    public void addRand(Rand rand) {
        randuri.get(coloanaCurenta).add(rand);
        linieCurenta = randuri.get(coloanaCurenta).size();
        if (linieCurenta == linieMax) {
            linieCurenta = 0;
            coloanaCurenta++;
        }
    }
}
