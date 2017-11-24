package ru.ark.Clinic;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ClinicTest {

    @Test
    public void testIfAddClientWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        Client client = new Client("Ben", new Dog("Gur"));
        clinic.addNewClient(client);
        ArrayList<Client> clients = clinic.getClients();
        assertEquals(client, clients.get(0));
    }

    @Test
    public void testIfFindClientByPetNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addNewClient(newClient);
        assertEquals(newClient, clinic.findClientByPetName("Ben"));
    }

    @Test
    public void testIfFindClientByNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addNewClient(newClient);
        assertEquals(newClient, clinic.findClientByName("Bob"));
    }

    @Test
    public void testIfSetClientNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        clinic.setClientName(0, "Peter");
        ArrayList<Client> clients = clinic.getClients();
        assertEquals("Peter", clients.get(0).getName());
    }

    @Test
    public void testIfSetPetNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        clinic.setPetName(0, "Lucky");
        ArrayList<Client> clients = clinic.getClients();
        assertEquals("Lucky", clients.get(0).getPet().getName());
    }

    @Test
    public void testIfSetPetWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        Cat cat = new Cat("Masha");
        clinic.setPet(0, cat);
        ArrayList<Client> clients = clinic.getClients();
        assertEquals(cat, clients.get(0).getPet());
    }

    @Test
    public void testIfRemoveClientWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Dave", new Cat("Murka")));
        ArrayList<Client> clients = clinic.getClients();
        clinic.addNewClient(new Client("Dave", new Cat("Murka")));
        clinic.removeClient(1);
        assertArrayEquals(clients.toArray(), clinic.getClients().toArray());
    }

    @Test
    public void testIfShowAllClientsWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        ArrayList<Client> client = clinic.getClients();
        String expected = 0 + ". " + client.get(0).toString() + "\n";
        assertEquals(expected, clinic.showAllClients());
    }

    @Test
    public void testIfGetClientsWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic();
        Client client = new Client("Bob", new Dog("Bill"));
        clinic.addNewClient(client);
        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client);
        assertArrayEquals(clients.toArray(), clinic.getClients().toArray());
    }


    @Test(expected = UserException.class)
    public void testIfFindClientByPetNameThrowsUserException() throws UserException {
        Clinic clinic = new Clinic();
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addNewClient(newClient);
        assertEquals(newClient, clinic.findClientByPetName("David"));
    }

    @Test(expected = UserException.class)
    public void testIfFindClientByNameThrowsUserException() throws UserException {
        Clinic clinic = new Clinic();
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addNewClient(newClient);
        assertEquals(newClient, clinic.findClientByName("Nina"));
    }

    @Test(expected = UserException.class)
    public void testIfSetClientNameThrowsUserException() throws UserException {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        clinic.setClientName(2, "Peter");

    }

    @Test(expected = UserException.class)
    public void testIfSetPetNameThrowsUserException() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        clinic.setPetName(2, "Lucky");

    }

    @Test(expected = UserException.class)
    public void testIfSetPetThrowsUserException() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Bob", new Dog("Ben")));
        Cat cat = new Cat("Masha");
        clinic.setPet(1, cat);
    }

    @Test(expected = UserException.class)
    public void testIfRemoveClientThrowsUserException() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addNewClient(new Client("Dave", new Cat("Murka")));
        clinic.removeClient(3);
    }
}
