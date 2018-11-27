package org.octank.claims.main;

/**
 * @author rvvittal
 */
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.octank.claims.model.Claim;
import org.octank.claims.model.ClaimProcessing;
import org.octank.claims.model.ClaimProcessingId;
import org.octank.claims.model.Staff;

//import com.fasterxml.classmate.AnnotationConfiguration;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (null != sessionFactory)
            return sessionFactory;
        
        Configuration configuration = new Configuration();
      
        configuration.configure("hibernate.cfg.xml");
      
        configuration.addAnnotatedClass(ClaimProcessing.class);
        configuration.addAnnotatedClass(ClaimProcessingId.class);
        configuration.addAnnotatedClass(Staff.class);
        configuration.addAnnotatedClass(Claim.class);
       
       
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
        return sessionFactory;
    }
}
