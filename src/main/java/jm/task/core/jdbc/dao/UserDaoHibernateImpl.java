//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//
//import java.util.List;
//
//import jm.task.core.jdbc.util.Util;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import net.javaguides.hibernate.entity.User;
//import net.javaguides.hibernate.util.Util;
//
//public class UserDaoHibernateImpl implements UserDao {
//    public UserDaoHibernateImpl() {
//
//    }
//
//
//    @Override
//    public void createUsersTable() {
//
//    }
//
//    @Override
//    public void dropUsersTable() {
//
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the student object
//            session.save(user);
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//
//    }
//}
