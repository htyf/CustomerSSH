package zyf.service;

import java.util.List;

import zyf.entity.Customer;

public interface ICustomerService {
	
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Customer addCustomer(Customer cust) throws Exception;
	
	/**
	 * 获取所有的客户信息
	 * @return
	 */
	List<Customer> getAllCustomer() throws Exception;
	
	/**
	 * 获取所有指定客户名称的客户信息
	 * @return
	 */
	Customer getCustomerByName(Customer cust) throws Exception;
	
	/**
	 * 获取所有指定客户名称的客户信息
	 * @return
	 */
	List<Customer> getAllCustomerByName(String name) throws Exception;
	/**
	 * 获取所有指定客户id的客户信息
	 * @return
	 */
	Customer getCustomerById(Customer cust) throws Exception;
	/**
	 * 获取所有指定联系人id的客户信息
	 * @return
	 */
	List<Customer> getCustomerByLinkId(String linkid) throws Exception;
	
	/**
	 * 删除客户信息
	 * @return
	 */
	int deleteCustomer(Customer cust) throws Exception;
	
	/**
	 * 修改客户信息
	 * @return
	 */
	int updateCustomer(Customer cust) throws Exception;
	
	/**
	 * 判断客户是否存在
	 * @param cust
	 * @return
	 * @throws Exception
	 */
	public Customer isExist(Customer cust) throws Exception;

}
