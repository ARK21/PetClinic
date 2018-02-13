package store;

import models.Pet;
import models.User;
import java.util.Collection;

public interface StorageBase {

    Collection<User> values();

    int add(User user);

    User get(int id);

    void edit(User user);

    void delete(int id);

    Collection<User> findByName(String name);

    void close();

    Pet createPet(String type, String name);
}
