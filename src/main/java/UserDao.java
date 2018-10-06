package main.java;

//здесь я сделаю коннект к базе+управление данными в БД, после запроса из UserServlet

import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class UserDao {


    public void addUser(User application) {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Integer result = (Integer) session.save(application);
        session.getTransaction().commit();

    }

    public void deleteUser(User application) {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(application);
        session.getTransaction().commit();


    }

    public void updateUser(User application) {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(application);
        session.getTransaction().commit();
    }

    public List<User> getAllUsers() {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> list = session.createCriteria(User.class).list();
        return list;
    }

    public User getUserById(int userId) {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        User result = (User) session.load(User.class, userId);
        session.getTransaction().commit();
        return result;
    }


}
