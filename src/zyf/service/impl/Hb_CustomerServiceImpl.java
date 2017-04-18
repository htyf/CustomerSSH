package zyf.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import zyf.dao.ICustomerDao;
import zyf.entity.Customer;
import zyf.service.ICustomerService;

@Transactional
public class Hb_CustomerServiceImpl implements ICustomerService{
	ICustomerDao icd = null;

	public ICustomerDao getIcd() {
		return icd;
	}
	public void setIcd(ICustomerDao icd) {
		this.icd = icd;
	}
	
	
	@Override
	public Customer addCustomer(Customer cust) throws Exception {
		if(cust==null){
			return null;
		}
		Customer customer = icd.queryByName(cust);
		if(customer==null){
			String save = icd.save(cust);//返回的是id
			if(save!=null&&save!=""){
				Customer c = icd.queryByName(cust);
				return c;
			}else{
				return null;
			}
		}else{
			return null;
		}
	
	}
	/**
	 * 判断用户是否存在
	 * @param cust
	 * @return
	 * @throws Exception
	 */
	public Customer isExist(Customer cust) throws Exception{
		if(cust==null){
			return null;
		}
		Customer customer = icd.queryByName(cust);
		if(customer==null){
			return null;
		}else{
			return customer;
		}
		
	}
	@Override
	public List<Customer> getAllCustomer() throws Exception {
		// TODO Auto-generated method stub
		return icd.query();
	}
	@Override
	public Customer getCustomerByName(Customer cust) throws Exception {
		// TODO Auto-generated method stub
		return icd.queryByName(cust);
	}
	@Override
	public List<Customer> getAllCustomerByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return icd.queryByName(name);
	}
	
	@Override
	public int deleteCustomer(Customer cust) throws Exception {
		// TODO Auto-generated method stub
		return icd.delete(cust);
	}
	@Override
	public int updateCustomer(Customer cust) throws Exception {
		// TODO Auto-generated method stub
		return icd.update( cust);
	}
	@Override
	public Customer getCustomerById(Customer cust) throws Exception {
		// TODO Auto-generated method stub
		return icd.queryById(cust);
	}
	@Override
	public List<Customer> getCustomerByLinkId(String linkid) throws Exception {
		// TODO Auto-generated method stub
		return icd.queryByLinkId(linkid);
	}
	
	
	
}
