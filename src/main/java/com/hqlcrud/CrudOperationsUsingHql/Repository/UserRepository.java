package com.hqlcrud.CrudOperationsUsingHql.Repository;

import com.hqlcrud.CrudOperationsUsingHql.Entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory factory;

    // Create or Update
    public String saveUser(UserEntity user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            transaction.commit();
            return "User saved successfully.";
        } catch (Exception e) {
            transaction.rollback();
            return "Error: " + e.getMessage();
        } finally {
            session.close();
        }
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserEntity> users = null;
        try {
            String hql = "FROM UserEntity";
            Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
            users = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    // Get user by ID
    public UserEntity getUserById(Long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = null;
        try {
            user = session.get(UserEntity.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    // Update user
    public String updateUser(Long id, String name, String email) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "UPDATE UserEntity u SET u.name = :name, u.email = :email WHERE u.id = :id";
            Query<?> query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("email", email);
            query.setParameter("id", id);
            int rowsAffected = query.executeUpdate();
            transaction.commit();
            return rowsAffected + " user(s) updated.";
        } catch (Exception e) {
            transaction.rollback();
            return "Error: " + e.getMessage();
        } finally {
            session.close();
        }
    }

    // Delete user
    public String deleteUser(Long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "DELETE FROM UserEntity u WHERE u.id = :id";
            Query<?> query = session.createQuery(hql);
            query.setParameter("id", id);
            int rowsDeleted = query.executeUpdate();
            transaction.commit();
            return rowsDeleted + " user(s) deleted.";
        } catch (Exception e) {
            transaction.rollback();
            return "Error: " + e.getMessage();
        } finally {
            session.close();
        }
    }
}
