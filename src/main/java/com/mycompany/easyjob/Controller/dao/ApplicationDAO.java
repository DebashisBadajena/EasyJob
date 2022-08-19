/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.dao;

import com.mycompany.easyjob.Controller.entity.ApplicationTable;
import com.mycompany.easyjob.Controller.entity.ShortlistedApplicatiionTable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Deb
 */
public class ApplicationDAO {

   private SessionFactory sessionFactory;

   public ApplicationDAO(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public static String getApplyDate() {
      String date = null;

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date d = new Date();

      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      formatter = new SimpleDateFormat("dd MMMM yyyy");
      String formatedDate = (String) formatter.format(d);

      return formatedDate;
   }

   public static String getTime() {

      DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
      Date d = new Date();
      String formatedTime = (String) dateFormat.format(d);

      return formatedTime;
   }

   public List<ApplicationTable> getAppliedJobByUserId(String UserId) {
      List<ApplicationTable> list = null;
      ApplicationTable applicationTable = null;
      Session session = sessionFactory.openSession();

      try {

         String query = "from ApplicationTable where userId=:u";
         Query q = session.createQuery(query);
         q.setParameter("u", UserId);
         list = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }

      return list;
   }

   public List<ApplicationTable> getApplicantByJobId(String JobId) {
      List<ApplicationTable> list = null;
      ApplicationTable applicationTable = null;
      Session session = sessionFactory.openSession();

      try {

         String query = "from ApplicationTable where jobId=:j";
         Query q = session.createQuery(query);
         q.setParameter("j", JobId);
         list = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }

      return list;
   }

   public List<ApplicationTable> getApplicationTableByJobIdAndUserId(String JobId, String UserId) {
      List<ApplicationTable> list = null;
      Session session = null;
      //HQL
      try {
         String q = "from ApplicationTable where jobId = :jId and userId = :uId";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("jId", JobId);
         query.setParameter("uId", UserId);
         list = query.list();

      } catch (Exception e) {

         e.printStackTrace();
      } finally {

         session.close();

      }

      return list;
   }

   
    public void deleteJobByJobId(String JobId){
   Session session=sessionFactory.openSession();
      try {
         Transaction tx=session.beginTransaction();
      String DeleteQuery="delete from ApplicationTable where jobId=:jId";
         Query q=session.createQuery(DeleteQuery);
         q.setParameter("jId", JobId);
         q.executeUpdate();
         tx.commit();
         
         
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
      
   
   
   }

   
}
