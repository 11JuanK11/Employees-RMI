package Domain;


import java.io.Serializable;
import java.util.List;

public class Employees implements Serializable {
    private int id;
    private String name;
    private List<Float> numberOfMonths;

    public Employees(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(List<Float> numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

}
