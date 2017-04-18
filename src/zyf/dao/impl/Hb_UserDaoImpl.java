package zyf.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zyf.dao.IUserDao;
import zyf.entity.User;
import zyf.utils.Hb_Connection;

public class Hb_UserDaoImpl  extends HibernateDaoSupport  implements IUserDao{

	@Override
	public int save(Connection conn, User user) throws Exception {
		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		int status = 0;
		try{
			//开启事务
			transaction = session.beginTransaction();
			Serializable save = session.save(user);
			status=1;
			System.out.println("保存成功："+save);
			transaction.commit();
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.save(Connection, User)***");
		}catch(Exception e){
			status=0;
			transaction.rollback();
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int update(Connection conn, User user) throws Exception {

		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		int status = 0;
		try{
			//开启事务
			transaction = session.beginTransaction();
			session.update(user);
			status=1;
			System.out.println("修改成功");
			transaction.commit();
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.update(Connection, User)***");
		}catch(Exception e){
			status=0;
			transaction.rollback();
			e.printStackTrace();
		}
		return status;


	}

	@Override
	public int delete(Connection conn, User user) throws Exception {

		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		int status = 0;
		try{
			//开启事务
			transaction = session.beginTransaction();
			session.delete(user);
			status=1;
			System.out.println("删除成功");
			transaction.commit();
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.delete(Connection, User)***");
		}catch(Exception e){
			status=0;
			transaction.rollback();
			e.printStackTrace();
		}
		return status;


	}

	@Override
	public User queryById(User user) throws Exception {
		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		User u = null;
		try{
			//开启事务
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where userid=:userid");
			query.setString("userid", user.getUserid());
			List<User> userList = query.list();
			if(userList.size()==0){
				return null;
			}
			u = userList.get(0);
		}finally{
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.queryById(User)***");
		}
		return u;

	}

	@Override
	public User queryByName(User user) throws Exception {
		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		User u = null;
		try{
			//开启事务
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where username=:username");
			query.setString("username", user.getUsername());
			List<User> userList = query.list();
			if(userList.size()==0){
				return null;
			}
			u = userList.get(0);
		}finally{
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.queryByName(User)***");
		}
		return u;

	}
	
	@Test
	@Override
	public List<User> query() throws Exception {
		Session session = Hb_Connection.getConnection();
		Transaction transaction = null;
		List<User> userList = null;
		try{
			//开启事务
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User");
			 userList = query.list();
		}finally{
			System.out.println("***zyf.dao.impl.Hb_UserDaoImpl.query()***");
		}
		return userList;

	}


}
