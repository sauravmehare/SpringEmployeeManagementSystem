package com.employee.daoImpl;
import org.hibernate.Query;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import com.employee.repository.HibernateUtil2;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//private SessionFactory sessionFactory=HibernateUtil2.getSessionFactory();
	private SessionFactory sessionFactory; 
	
	public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl getting called");
		sessionFactory= HibernateUtil2.getSessionFactory();
	}
	
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		}
		catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

	}

	public void deleteEmployee(int employeeID) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.delete(getEmployee(employeeID));
		transaction.commit();

	}

	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		session.close();
	}

	public Employee getEmployee(int employeeID) {
		Session session=sessionFactory.openSession();
    	Employee employee=(Employee) session.get(Employee.class, employeeID);
		return employee;
	}

	public List<Employee> getAllEmp() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from Employee");
		employeeList=q.list();
		session.close();
		return employeeList;
	}

}
