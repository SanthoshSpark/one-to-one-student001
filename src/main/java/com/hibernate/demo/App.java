package com.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
    public static void main( String[] args ) {
    	
        SessionFactory sf = null;
        Session s = null;
        Transaction tx = null;
        
        try {
        	
        	sf = new Configuration().configure().buildSessionFactory();
        	s  = sf.openSession();
        	tx = s.beginTransaction();
        	
        /*	StudentDetails sd1 = new StudentDetails("Perambalur");
        	StudentDetails sd2 = new StudentDetails("Thuraiyur");
        	
        	Student s1 = new Student("Sabaree",sd1);
        	Student s2 = new Student("Gouse",sd2);
        	
        	s.save(s1);
        	s.save(s2);
        	*/
        	
        	Student s1 = s.get(Student.class, 1L);
        	
        	StudentDetails sd1 = s.get(StudentDetails.class, 1L);
        	
        	System.out.println(s1);
        	System.out.println(sd1);

        }
        catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
        catch (Exception e) {
        	if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
        finally {
			if(tx != null)
				tx.commit();
			if(s != null)
				s.close();
			if(sf != null)
				sf.close();
		}
    }
}
