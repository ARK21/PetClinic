package ru.ark.multithreading;

import ru.ark.Clinic.Clinic;

public class Admin extends Thread {

    private final Clinic clinic;
    private String name;

    public Admin(Clinic clinic, String name) {
        this.clinic = clinic;
        this.name = name;
        start();
    }

    public void browse() {
        synchronized (clinic) {
            while (ClinicEmulator.on) {
                try {
                    System.out.format("Поток %S. %S - %S ждет своей очереди. \n",
                            Thread.currentThread().getName(), this.getClass().getSimpleName(), this.name);
                    clinic.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("%s - %s запрашивает число клиентов: %d  \n",
                        this.getClass().getSimpleName(), this.name, clinic.getClients().size());
                clinic.notifyAll();
            }
        }
    }

    @Override
    public void run() {
        browse();
    }
}
