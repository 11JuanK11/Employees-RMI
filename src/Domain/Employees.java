package Domain;


import java.util.List;

public class Employees {
    private int id;
    private String name;
    private List<Byte> numberOfMonths;

    public Employees(int id, String name, List<Byte> numberOfMonths) {
        this.id = id;
        this.name = name;
        this.numberOfMonths = numberOfMonths;
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

    public List<Byte> getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(List<Byte> numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }
}
