package zyf.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zyf.entity.Customer;
import zyf.entity.User;
import zyf.service.ICustomerService;
import zyf.service.impl.Hb_CustomerServiceImpl;
import zyf.utils.Constants;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	//	CustomerServiceImpl ics = new CustomerServiceImpl();
	ICustomerService ics = null;
	public ICustomerService getIcs() {
		return ics;
	}
	public void setIcs(ICustomerService ics) {
		this.ics = ics;
	}


	Customer customer = new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * 添加客户
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{

		Customer cust = ics.addCustomer(customer);
		if(cust!=null){
			return Constants.ADDSUCCESS;
		}else{
			return Constants.FAILED;
		}

	}

	/**
	 * 判断用户是否存在
	 * @return
	 * @throws Exception 
	 */
	public String isExistCustomer() throws Exception{
		Customer cust = new Customer(customer.getCustName(), customer.getCustLevel(), customer.getCustSource(), customer.getCustLinkman(), 
				customer.getCustPhone(), customer.getCustMobile(), customer.getCustAddress(), 
				customer.getCustZip(), customer.getCustFax(), customer.getCustWebsite());
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		if(customer.getCustName()!=null){
			Customer customer = ics.isExist(cust);
			if(customer!=null){
				out.print(Constants.EXIST);
			}else{
				out.print(Constants.NOTEXIST);
			}
		}else{
			out.print(Constants.NOTEXIST);
		}
		out.flush();
		out.close();
		return null;

	}

	/***
	 * 获取所有的客户信息
	 * @return
	 * @throws Exception 
	 */
	public String getAllCustomer() throws Exception{
		List<Customer> allCustomer = ics.getAllCustomer();
		if(allCustomer!=null){
			ServletActionContext.getRequest().setAttribute("list",allCustomer );
			return Constants.LISTSUCCESS;
		}else{
			return Constants.FAILED;
		}
	}

	@Test
	public String  getAllCustomersAjax() throws Exception{
		Map<String,Object> map = new HashMap<>();
		List<Customer> allCustomer = ics.getAllCustomer();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		if(allCustomer!=null&&allCustomer.size()!=0){
			map.clear();
			map.put("status", "success");
			map.put("data", allCustomer);
			try{
				String jsonString = JSON.toJSONString(map);
				System.out.println("****"+jsonString);

				out.write(jsonString);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			map.clear();
			map.put("status", "failed");
			String jsonString = JSON.toJSONString(map);
			System.out.println(jsonString);
			out.write(jsonString);
		}
		out.flush();
		out.close();
		return null;

	}
	/***
	 * 获取所有指定名称的客户信息
	 * @return
	 * @throws Exception 
	 */
	public String getAllCustomerByName() throws Exception{

		List<Customer> allCustomer = ics.getAllCustomerByName(customer.getCustName());
		if(allCustomer!=null){
			ServletActionContext.getRequest().setAttribute("list", allCustomer);
			return Constants.LISTSUCCESS;
		}else{
			return Constants.FAILED;
		}





	}
	/**
	 * 删除客户
	 * @return
	 * @throws Exception 
	 */
	public String deleteCustomer() throws Exception{

		Customer cust = new Customer(customer.getCustId(),customer.getCustName(), customer.getCustLevel(), customer.getCustSource(), customer.getCustLinkman(), 
				customer.getCustPhone(), customer.getCustMobile(), customer.getCustAddress(), 
				customer.getCustZip(), customer.getCustFax(), customer.getCustWebsite());
		if(customer.getCustId()!=null){
			int delete = ics.deleteCustomer(cust);
			if(delete>0){
				return getAllCustomer();
			}else{
				return Constants.FAILED;
			}
		}else{
			return Constants.FAILED;
		}

	}

	/**
	 * 获取客户的原有数据并展示到页面
	 * @param cust
	 * @return
	 * @throws Exception 
	 */
	public String updateCustomer() throws Exception{
		Customer cust = new Customer(customer.getCustId());
		Customer customer = ics.getCustomerById(cust);
		if(customer!=null){
			ServletActionContext.getRequest().setAttribute("customer", customer);
			return Constants.UPDATESUCCESS;
		}else{
			return Constants.FAILED;
		}

	}
	/**
	 * 更新客户信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		Customer cust = new Customer(customer.getCustId(),customer.getCustName(), customer.getCustLevel(), customer.getCustSource(), customer.getCustLinkman(), 
				customer.getCustPhone(), customer.getCustMobile(), customer.getCustAddress(), 
				customer.getCustZip(), customer.getCustFax(), customer.getCustWebsite());
		if(customer.getCustId()!=null){
			int update = ics.updateCustomer(cust);
			if(update>0){
				return getAllCustomer();
			}else{
				return Constants.FAILED;
			}
		}else{
			return Constants.FAILED;
		}
	}


	public String getAllCustsByLidAjax() throws Exception{
		String linkid = (String)ServletActionContext.getRequest().getSession().getAttribute("linkId");
		System.out.println("================"+linkid);
		Map<String,Object> map = new HashMap<>();
		List<Customer> allCustomer = ics.getCustomerByLinkId(linkid);
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		if(allCustomer!=null&&allCustomer.size()!=0){
			map.clear();
			map.put("status", "successId");
			map.put("data", allCustomer);
			try{
				String jsonString = JSON.toJSONString(map);
				System.out.println("****"+jsonString);
				out.write(jsonString);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			allCustomer = ics.getAllCustomer();
			if(allCustomer!=null&&allCustomer.size()!=0){
				map.clear();
				map.put("status", "successAll");
				map.put("data", allCustomer);
				String jsonString = JSON.toJSONString(map);
				System.out.println(jsonString);
				out.write(jsonString);
			}else{
				map.clear();
				map.put("status", "failed");
				String jsonString = JSON.toJSONString(map);
				System.out.println(jsonString);
				out.write(jsonString);
			}
		}
		out.flush();
		out.close();
		return null;


	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

}
