/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.dao;

import com.mycompany.easyjob.Controller.entity.JobTable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
public class JobDAO {

   private SessionFactory sessionFactory;

   public JobDAO(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public static String getJobId(String userName) {
      String jobId = null;

      userName = userName.replaceAll("\\s+", "");

      DateFormat dateFormat = new SimpleDateFormat("HHmmss");
      Date d = new Date();
      String formatedTime = (String) dateFormat.format(d);
      jobId = userName + formatedTime;

      return jobId;
   }

   public static String getTime() {

      DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
      Date d = new Date();
      String formatedTime = (String) dateFormat.format(d);

      return formatedTime;
   }

   public static String getDate() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date d = new Date();

      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      formatter = new SimpleDateFormat("dd MMMM yyyy");
      String formatedDate = (String) formatter.format(d);

      return formatedDate;
   }

   public List<JobTable> getJob() {
      JobTable jobTable = null;
      Session session = sessionFactory.openSession();
      List<JobTable> list = null;
      try {
         String query = "from JobTable";
         Query q = session.createQuery(query);
         list = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         session.close();
      }

      return list;
   }

   public List<JobTable> getJobById(String emailId) {
      List<JobTable> list = null;
      JobTable jobTable = null;
      Session session = sessionFactory.openSession();
      try {

         String query = "from JobTable where user_mail_id=:id";
         Query q = session.createQuery(query);
         q.setParameter("id", emailId);
         list = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         session.close();
      }

      return list;
   }

   public JobTable getJobByJobId(String JobId) {
      JobTable jobTable = null;
      Session session = sessionFactory.openSession();
      try {

         String query = "from JobTable where job_id=:id";
         Query q = session.createQuery(query);
         q.setParameter("id", JobId);
         jobTable=(JobTable)q.uniqueResult();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         session.close();
      }

      return jobTable;
   }
   
   
   public void deleteJobByJobId(String JobId){
   Session session=sessionFactory.openSession();
      try {
         Transaction tx=session.beginTransaction();
      String DeleteQuery="delete from JobTable where job_id=:jId";
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
   
    
     public List<JobTable> getJobByTitel(String titel) {
      List<JobTable> list = null;
      JobTable jobTable = null;
      Session session = sessionFactory.openSession();
      try {

         String query = "from JobTable where post_titel=:t";
         Query q = session.createQuery(query);
         q.setParameter("t", titel);
         list = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         session.close();
      }

      return list;
   }
   
   
   

}
