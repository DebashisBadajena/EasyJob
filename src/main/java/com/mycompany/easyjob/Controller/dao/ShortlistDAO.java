/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.dao;

import com.mycompany.easyjob.Controller.entity.ApplicationTable;
import com.mycompany.easyjob.Controller.entity.JobTable;
import com.mycompany.easyjob.Controller.entity.ShortlistedApplicatiionTable;
import com.mycompany.easyjob.Controller.entity.UserTable;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Deb
 */
public class ShortlistDAO {

   private SessionFactory sessionFactory;

   public ShortlistDAO(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public List<ShortlistedApplicatiionTable> getShortlistTable(String CandidateId) {
      List<ShortlistedApplicatiionTable> Shortlist = null;

      Session session = sessionFactory.openSession();
      try {

         String query = "from ShortlistedApplicatiionTable where userId=:id";
         Query q = session.createQuery(query);
         q.setParameter("id", CandidateId);
         Shortlist = q.list();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         session.close();
      }

      
      
      return Shortlist;
   }
   
   
   public ShortlistedApplicatiionTable getCandidateByJobIdAndCandidateiD(String JobId,String CandidateId){
   ShortlistedApplicatiionTable slTable=null;
   Session session = null;
      //HQL
      try {
         String q = "from ShortlistedApplicatiionTable where jobId = :jId and userId = :uId";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("jId",JobId);
         query.setParameter("uId", CandidateId);
         slTable=(ShortlistedApplicatiionTable)query.uniqueResult();
            
         
      } catch (Exception e) {
         
         e.printStackTrace();
      } finally {

         session.close();

      }

   
   
   return slTable;
   }
   
    public List<ShortlistedApplicatiionTable> getShortListTAbleByJobIdAndCandidateiD(String JobId,String CandidateId){
      List<ShortlistedApplicatiionTable> list=null;
    Session session = null;
      //HQL
      try {
         String q = "from ShortlistedApplicatiionTable where jobId = :jId and userId = :uId";
         session = this.sessionFactory.openSession();
         Query query = session.createQuery(q);
         query.setParameter("jId",JobId);
         query.setParameter("uId", CandidateId);
            list=query.list();
         
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
      String DeleteQuery="delete from ShortlistedApplicatiionTable where jobId=:jId";
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
    
    
    public boolean checkForEligibility(String applicant_id,String job_id){
       List<String>subQualification=null;
       int experence;
       ApplicationDAO aDao=new ApplicationDAO(SessionFactoryProvider.getFactory());
       List<ApplicationTable> ut=aDao.getApplicationTableByJobIdAndUserId(job_id,applicant_id);
       
       JobDAO jDao=new JobDAO(SessionFactoryProvider.getFactory());
       JobTable jt=jDao.getJobByJobId(job_id);
       
       System.out.println("ut= "+ut);
       System.out.println("jt= "+jt);
       
    
    
      return false;
    }
    
    
}
