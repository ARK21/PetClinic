package ru.ark.multithreading;

import ru.ark.Clinic.Client;
import ru.ark.Clinic.Clinic;
import ru.ark.Clinic.Pet;

public class User extends Thread {

    private final Clinic clinic;
    private String name;
    private Pet pet;

    public User(Clinic clinic, String name, Pet pet) {
        this.clinic = clinic;
        this.name = name;
        this.pet = pet;
        start();
    }

    public void addMySelf() {
        synchronized (clinic) {
            clinic.addNewClient(new Client(this.name, this.pet));
            clinic.notifyAll();
        }

    }

    @Override
    public void run() {
        System.out.format(Thread.currentThread().getName() + " стартовал \n");
        addMySelf();
    }
}
