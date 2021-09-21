
package librarievirtuala;


public class Editura extends BusinessObjects{
   private static int id=1;
   private String nume;

    public Editura() {
        super(id++);
    }

    public Editura(String nume) {
        super(id++);
        this.nume = nume;
    }
    public Editura(int id){
        super(id);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }    


    @Override
    public String toString() {
        return "Editura{" + "nume=" + nume + '}';
    }
    
    
   
}
