package store;

import models.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class HibernateStorage implements StorageBase {
    private final SessionFactory factory;

    public HibernateStorage() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public Collection<User> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from User clinic ORDER BY id ASC").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public int add(User user) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            return user.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(new User(id, null, null));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void close() {
        this.factory.close();
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

    @Override
    public User get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (User) session.get(User.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void edit(User user) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Collection<User> findByName(String name) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from User as user where user.name=:name ORDER BY id ASC");
            query.setString("name", name);
            return query.list();
        } finally {
            tx.commit();
            session.close();
        }
    }


}
