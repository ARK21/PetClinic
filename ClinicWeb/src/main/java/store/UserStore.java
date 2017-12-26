package store;

import models.User;
import ru.ark.Clinic.Cat;
import ru.ark.Clinic.Dog;
import ru.ark.Clinic.Parrot;
import ru.ark.Clinic.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {


    private static UserStore ourInstance = new UserStore();

    public static UserStore getInstance() {
        return ourInstance;
    }


    private UserStore() {
    }

    public static List<User> getUsers() throws SQLException, ClassNotFoundException {
        Connection c = getConnettion();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM clinic");
        ResultSet resultSet = ps.executeQuery();

        List<User> users = new ArrayList<User>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String petType = resultSet.getString(3);
            String petName = resultSet.getString(4);
            users.add(new User(id, name, createPet(petType, petName)));
        }
        return users;
    }

    public static void add(User user) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnettion();
             PreparedStatement ps = c.prepareStatement("INSERT INTO clinic (user_name, pet_type, pet_name) VALUES (?,?,?)");) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPet().getClass().getSimpleName());
            ps.setString(3, user.getPet().getName());
            ps.execute();
        }
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnettion();
             PreparedStatement ps = c.prepareStatement("DELETE FROM clinic WHERE user_id=?");) {
            ps.setInt(1, id);
            ps.execute();
        }

    }

    public static List<User> search(String name) {
        List<User> foundUser = new ArrayList<User>();
        try {
            Connection c = getConnettion();
            PreparedStatement ps = c.prepareStatement("SELECT * from clinic WHERE user_name=?");
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String petType = resultSet.getString(3);
                String petName = resultSet.getString(4);
                foundUser.add(new User(id, userName, createPet(petType, petName)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public static Connection getConnettion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:1121/clinic_base", "postgres", "2114");
    }

    public  static Pet createPet(String type, String name) {
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
