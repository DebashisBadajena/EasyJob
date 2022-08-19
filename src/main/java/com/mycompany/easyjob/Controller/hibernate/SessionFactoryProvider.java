/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.hibernate;

import javax.servlet.http.HttpServlet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Deb
 */
public class SessionFactoryProvider extends HttpServlet {

   private static SessionFactory sessionFactory;

   public static SessionFactory getFactory() {
      
      try {
       
         if(sessionFactory==null){
         sessionFactory=new Configuration().configure().buildSessionFactory();
         
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      
      return sessionFactory;
   }

}
