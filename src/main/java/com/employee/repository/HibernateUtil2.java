package com.employee.repository;

import com.employee.entity.Employee;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;



@Repository
public class HibernateUtil2 {
	 private static SessionFactory sessionFactory;
	 
	 public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	               
	                settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
	                settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
	                settings.put(Environment.USER, "xe");
	                settings.put(Environment.PASS, "xe");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle8iDialect");

	                settings.put(Environment.SHOW_SQL, "true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	                configuration.setProperties(settings);

	                configuration.addAnnotatedClass(Employee.class);

	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }

}
