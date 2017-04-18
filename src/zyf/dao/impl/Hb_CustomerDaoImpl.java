package zyf.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zyf.dao.ICustomerDao;
import zyf.dao.IUserDao;
import zyf.entity.Customer;
import zyf.entity.User;
import zyf.utils.Hb_Connection;

public class Hb_CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao{

	@Override
	public String save(Customer cust) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String save = (String)session.save(cust);
		System.out.println("保存成功："+save);
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.save(Connection, Customer)***");

		return save;
	}

	@Override
	public int update( Customer cust) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(cust);
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.update(Connection, Customer)***");
		return 1;

	}

	@Override
	public int delete( Customer cust) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Customer customer = queryById(cust);
		if(customer==null){
			return 0;
		}
		session.delete(customer);
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.delete(Connection, Customer)***");
		return 1;

	}

	@Override
	public Customer queryById(Customer cust) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Customer customer = null;
		Query query = session.createQuery("from Customer where custId='"+cust.getCustId()+"'");
		List<Customer> custList = query.list();
		if(custList.size()==0){
			return null;
		}
		customer = custList.get(0);
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.queryById(Customer)***");
		return customer;

	}

	@Override
	public Customer queryByName(Customer cust) throws Exception {

		//通过会话工厂获取session
		Session session = this.getSessionFactory().getCurrentSession();
		//执行查询
		Query query = session.createQuery("from Customer where custName=?");
		query.setString(0, cust.getCustName());
		List<Customer> custList = query.list();
		System.out.println("custList="+custList);
		if(custList.size()==0){
			return null;
		}
		Customer customer = custList.get(0);

		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.queryByName(Customer)***");
		return customer;

	}

	@Override
	public List<Customer> query() throws Exception {
		//加载默认配置文件
		Configuration cfg = new Configuration().configure();
		//创建会话工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//通过会话工厂获取session
		Session session = sessionFactory.openSession();
		//执行查询
		Query query = session.createQuery("from Customer");
		List<Customer> custList = query.list();
		System.out.println(custList+"==================");		
		session.close();
		sessionFactory.close();
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.query()***");
		return custList;

	}

	@Override
	public List<Customer> queryByName(String name) throws Exception {
		//加载默认配置文件
		Configuration cfg = new Configuration().configure();
		//创建会话工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//通过会话工厂获取session
		Session session = sessionFactory.openSession();
		//执行查询
		Query query = session.createQuery("from Customer where custName like '%"+name+"%'");
		List<Customer> custList = query.list();
		session.close();
		sessionFactory.close();
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.queryByName(String)***");
		return custList;

	}

	@Override
	public List<Customer> queryByLinkId(String linkid) throws Exception {
		Session session = Hb_Connection.getConnection();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class,"cust");
		criteria.add(Restrictions.eq("cust.lkmLinkMans.lkmId", linkid));
		List<Customer> list = criteria.list();
		System.out.println(list);
		System.out.println("***zyf.dao.impl.Hb_CustomerDaoImpl.queryByLinkId(String)***");
		return list;
	}


}


