package ru.ark.Clinic;

public class Parrot implements Pet {

    private String name;

    public Parrot(String name) {
        this.name = name;
    }


    public void makeSound() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
