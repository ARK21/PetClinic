package store;

import models.User;
import models.Cat;
import models.Dog;
import models.Parrot;
import models.Pet;
import service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SQLStorage implements StorageBase {

    private Connection connection;

    public SQLStorage() {
        Settings settings = Settings.getInstance();
        try {
            Class.forName(settings.value("jdbc.driver"));
            connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> values() {
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clinic ORDER BY user_id ASC");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String petType = resultSet.getString(3);
                String petName = resultSet.getString(4);
                users.add(new User(id, name, createPet(petType, petName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int add(User user) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO clinic " +
                "(user_name, pet_type, pet_name) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPet().getClass().getSimpleName());
            ps.setString(3, user.getPet().getName());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            while (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't create new user");
    }

    @Override
    public User get(int id) {
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement("SELECT * from clinic WHERE user_id=(?)")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(id, rs.getString(2), createPet(rs.getString(3), rs.getString(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM clinic WHERE user_id=?")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(User user) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE clinic set user_name = (?), pet_type = (?), " +
                "pet_name = (?) WHERE user_id = (?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPet().getType());
            ps.setString(3, user.getPet().getName());
            ps.setInt(4, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Collection<User> findByName(String name) {
        List<User> foundUser = new ArrayList<User>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * from clinic WHERE user_name=(?) ORDER BY user_id ASC")) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String petType = resultSet.getString(3);
                String petName = resultSet.getString(4);
                foundUser.add(new User(id, userName, createPet(petType, petName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pet createPet(String type, String name) {
        Pet pet = null;
        if (type.equalsIgnoreCase("Cat")) {
            pet = new Cat(name);
        } else if (type.equalsIgnoreCase("Dog")) {
            pet = new Dog(name);
        } else if (type.equalsIgnoreCase("Parrot")) {
            pet = new Parrot(name);
        }
        return pet;
    }


}