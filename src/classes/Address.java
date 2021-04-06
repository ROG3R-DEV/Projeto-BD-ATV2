package classes;

public class Address extends Client {
    private int id; 
    private String place;
    private int number;
    private String city;
    private String state;

    Address(int idclient, String name, String email, int id, String place, int number, String city, String state) {
        super(idclient, name, email);
        this.id = id;
        this.place = place;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return this.id;
    }

    public String getPlace() {
        return this.place;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}