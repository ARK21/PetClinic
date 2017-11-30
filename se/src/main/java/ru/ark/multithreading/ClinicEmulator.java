package ru.ark.multithreading;

import ru.ark.Clinic.Cat;
import ru.ark.Clinic.Clinic;

public class ClinicEmulator {

    public Clinic clinic = new Clinic();
    public static boolean on = true;

    public static void main(String[] args) {
        ClinicEmulator cl = new ClinicEmulator();
        Admin admin = new Admin(cl.clinic, "SASHA");
        Admin admin1 = new Admin(cl.clinic, "MASHA");
        for (int i = 0; i < 25 ; i++) {
            User user = new User(cl.clinic, "User " + i, new Cat("Cat " + i));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        on = false;
    }

}
