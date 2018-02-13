package models;


public class Parrot extends Pet {

    private String name;

    public Parrot(String name) {
        super(name, "Parrot");
    }

    public String getName() {
       return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }
}
