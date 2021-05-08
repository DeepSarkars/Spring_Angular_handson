package com.example;


import java.util.List; 
 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ManageCountry {
   private static SessionFactory factory; 
   private static final Logger LOGGER = LoggerFactory.getLogger(ManageCountry.class);
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageCountry obj = new ManageCountry();

     
      obj.listCountries();
   }
   
   public void listCountries( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List countries = session.createQuery("FROM Country").list(); 
         LOGGER.debug("Countries: {}", countries);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
 

}