package com.greatlearning.CRM.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.CRM.entity.Customer;


@Repository
public class CustomerServiceImpl implements CustomerService{

	
private SessionFactory sessionFactory ;
	
	private Session session ;
	
	@Autowired (required = true)
	
	CustomerServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
		try {
			session = sessionFactory.getCurrentSession();
		}
		catch(HibernateException e){
			session = sessionFactory.openSession();
		}
	}
	@Override
	@Transactional
	public Customer findById(int theId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
Customer customer = new Customer();
		
		Transaction tx = session.beginTransaction();
		customer =session.get(Customer.class , theId);
		tx.commit();
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer thecustomer) {

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(thecustomer);
		tx.commit();
		
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer =session.get(Customer.class , theId);
		session.delete(customer);
		tx.commit();
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
	Transaction tx = session.beginTransaction();
		
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers ;
	}

}
