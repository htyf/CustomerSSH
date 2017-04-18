package zyf.dao;

import java.sql.Connection;
import java.util.List;

import zyf.entity.Customer;
import zyf.entity.User;

public interface ICustomerDao {
	
	/**
	 * 添加数据到数据库
	 * @param user
	 * @return
	 * @throws Exception
	 */
	String save(Customer cust) throws Exception;
	
	/**
	 * 更新数据库中数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int update(Customer cust) throws Exception;
	
	/**
	 * 删除数据库中数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int delete(Customer cust) throws Exception;
	
	/**
	 * 根据id查询数据库中的记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Customer queryById(Customer cust) throws Exception;
	
	/**
	 * 根据name查询数据库中的记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Customer queryByName(Customer cust) throws Exception;
	
	/**
	 * 根据名字获取数据
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<Customer> queryByName(String name) throws Exception;
	
	
	
	/**
	 * 查询数据库中所有的记录
	 * @return
	 * @throws Exception
	 */
	List<Customer> query() throws Exception;
	
	/**
	 * 根据联系人id查找该联系人下所有的客户记录
	 * @return
	 * @throws Exception
	 */
	List<Customer> queryByLinkId(String linkid) throws Exception;

}
