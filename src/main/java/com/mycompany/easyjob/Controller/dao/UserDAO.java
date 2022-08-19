/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.dao;

import com.mycompany.easyjob.Controller.entity.UserTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Deb
 */
public class UserDAO {

   private SessionFactory sessionFactory;

   public UserDAO(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public UserTable getUserByEmailIdAndPassword(String email_id, String password) {
      UserTable user = null;
      Session session = null;
      //HQL
      try {
         String q = "from UserTable where email_id = :e and password = :p";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("e", email_id);
         query.setParameter("p", password);
         user = (UserTable) query.uniqueResult();

      } catch (Exception e) {

         e.printStackTrace();
      } finally {

         session.close();

      }

      return user;
   }

   public UserTable getUserByEmailIdAndAnswer(String email_id, String answer) {
      UserTable user = null;
      Session session = null;
      //HQL
      try {
         String q = "from UserTable where email_id = :e and answer = :a";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("e", email_id);
         query.setParameter("a", answer);
         user = (UserTable) query.uniqueResult();

      } catch (Exception e) {

         e.printStackTrace();
      } finally {

         session.close();

      }

      return user;
   }

   public UserTable getUser(String emailId) {
      UserTable userTable = null;
      Session session = null;
      try {
         String q = "from UserTable where email_id = :e";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("e", emailId);
         userTable = (UserTable) query.uniqueResult();

      } catch (Exception e) {

         e.printStackTrace();
      } finally {

         session.close();
      }

      return userTable;
   }

   public void updatePassword(String UserId, String Password) {

      Session session = null;
      Transaction tx = null;

      try {
         session = sessionFactory.openSession();
         tx = session.beginTransaction();
         String q = "update UserTable set password=:p where email_id=: id";
         Query query = session.createQuery(q);
         query.setParameter("p", Password);
         query.setParameter("id", UserId);
         query.executeUpdate();
         tx.commit();

      }catch(Exception e){
      e.printStackTrace();
      
      } finally {
         
         session.close();
      }

   }

}
