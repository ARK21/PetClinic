package store;

import models.Pet;
import models.User;

import java.util.Collection;

public class Storage implements StorageBase {
    private static Storage ourInstance = new Storage();

    StorageBase storage = new SQLStorage();

    public static Storage getInstance() {
        return ourInstance;
    }

    private Storage() {
    }


    @Override
    public Collection<User> values() {
        return storage.values();
    }

    @Override
    public int add(User user) {
        return storage.add(user);
    }

    @Override
    public User get(int id) {
        return storage.get(id);
    }

    @Override
    public void edit(User user) {
        storage.edit(user);
    }

    @Override
    public void delete(int id) {
        storage.delete(id);
    }

    @Override
    public Collection<User> findByName(String name) {
        return storage.findByName(name);
    }

    @Override
    public void close() {
        storage.close();
    }

    @Override
    public Pet createPet(String type, String name) {
        return storage.createPet(type, name);
    }

    public void setStorage(String storage) {
        if (storage.equals("Jdbc")) {
            this.storage = new SQLStorage();
        } else if (storage.equals("Hb")) {
            this.storage = new HibernateStorage();
        }
    }
}
