package ru.ark.Clinic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ClinicTest {

    @Test
    public void testIfAddClientWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        Client client = new Client("Ben", new Dog("Gur"));
        clinic.addClient(0, client);
        Client [] clients = clinic.getClients();
        assertEquals(client, clients[0]);
    }

    @Test
    public void testIfFindClientByPetNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addClient(0,newClient);
        assertEquals(newClient, clinic.findClientByPetName("Ben"));
    }

    @Test
    public void testIfFindClientByNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        Client newClient = new Client("Bob", new Dog("Ben"));
        clinic.addClient(0,newClient);
        assertEquals(newClient, clinic.findClientByName("Bob"));
    }

    @Test
    public void testIfSetClientNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        clinic.addClient(0,new Client("Bob", new Dog("Ben")));
        clinic.setClientName(0, "Peter");
        Client [] clients = clinic.getClients();
        assertEquals("Peter", clients[0].getName());
    }

    @Test
    public void testIfSetPetNameWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        clinic.addClient(0,new Client("Bob", new Dog("Ben")));
        clinic.setPetName(0,"Lucky");
        Client [] clients = clinic.getClients();
        assertEquals("Lucky", clients[0].getPet().getName());
    }

    @Test
    public void testIfSetPetWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        clinic.addClient(0,new Client("Bob", new Dog("Ben")));
        Cat cat = new Cat("Masha");
        clinic.setPet(0, cat);
        Client [] clients = clinic.getClients();
        assertEquals(cat, clients[0].getPet());
    }

    @Test
    public void testIfRemovePetWorksCorrectly() throws Exception {
    }

    @Test
    public void testIfRemoveClientWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        clinic.addClient(0, new Client("Dave", new Cat("Murka")));
        Client [] clients = clinic.getClients();
        clinic.addClient(1, new Client("Dave", new Cat("Murka")));
        clinic.removeClient(1);
        assertArrayEquals(clients, clinic.getClients());
    }

    @Test
    public void testIfShowAllClientsWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        clinic.addClient(0,new Client("Bob", new Dog("Ben")));
        Client [] client = clinic.getClients();
        String expected = 0 + ". " + client[0].toString() + "\n";
        assertEquals(expected, clinic.showAllClients());
    }

    @Test
    public void testIfGetClientsWorksCorrectly() throws Exception {
        Clinic clinic = new Clinic(1);
        Client client = new Client("Bob", new Dog("Bill"));
        clinic.addClient(0, client);
        Client [] clients = {client};
        assertArrayEquals(clients, clinic.getClients());
    }
}
