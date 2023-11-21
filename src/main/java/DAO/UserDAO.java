package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtility;

import java.util.List;

public class UserDAO {

    public void saveUser(User user) {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Update User
     * @param user
     */
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete User
     * @param id
     */
    public void deleteUser(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public User getUser(int id) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(User.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < User > getAllUser() {

        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from User").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }

//    public void saveUser(User user){
//        Transaction transaction = null;
//        Session session = HibernateUtility.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//            session.save(user);
//            transaction.commit();
//        }catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    public void updateUser(User user){
//        Transaction transaction = null;
//        Session session = HibernateUtility.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//            session.update(user);
//            transaction.commit();
//        } catch (Exception e){
//            if (transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    public void deleteUser(int id){
//        Transaction transaction = null;
//        Session session = HibernateUtility.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//
//            User user = session.get(User.class, id);
//            if (user != null){
//                session.delete(user);
//                System.out.println("user is deleted");
//            }
//            transaction.commit();
//        } catch (Exception e){
//            if (transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    public User getUser(int id){
//        Transaction transaction = null;
//        User user = null;
//        Session session = HibernateUtility.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//            user = session.get(User.class, id);
//            transaction.commit();
//        } catch (Exception e){
//            if (transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//        return user;
//    }
//
//    public List<User> getAllUser(){
//        Transaction transaction = null;
//        List<User> listOfUser = null;
//        Session session = HibernateUtility.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//            listOfUser = session.createQuery("from User").getResultList();
//            transaction.commit();
//        } catch (Exception e){
//            if (transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//        return listOfUser;
//    }
}
