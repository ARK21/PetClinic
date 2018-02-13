package models;


public class User {

    private int id;
    private String name;
    private Pet pet;

    public User(int id, String name, Pet pet) {
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    public User () {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


}
