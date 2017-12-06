package models;

import ru.ark.Clinic.Pet;

public class User {


    private int id;
    private String name;
    private Pet pet;

    public User(int id, String name, Pet pet) {
        this.id = id;
        this.name = name;
        this.pet = pet;
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

    @Override
    public String toString() {
        return "User{" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", " + pet.getClass().getSimpleName() +
                ", name " + pet.getName() +
                '}';
    }
}
