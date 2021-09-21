
package librarievirtuala;


public class BusinessObjects {
    private int id;

    public BusinessObjects(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BusinessObjects other = (BusinessObjects) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
