package Data;

public class compet {
    public Integer id;
    public String Name, City, Ref;


    public compet(Integer id, String name, String city, String ref) {
        this.id = id;
        Name = name;
        City = city;
        Ref = ref;
    }

    public compet(String name, String city, String ref) {
        Name = name;
        City = city;
        Ref = ref;
    }

    public String getCity() {
        return City;
    }

    public void setSurname(String city) {
        City = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    @Override
    public String toString() {
        return "(" + "'" + Name + "','" + City + "','" + Ref + "')";
    }
}
