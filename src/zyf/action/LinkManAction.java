package zyf.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zyf.entity.Customer;
import zyf.entity.LinkMan;
import zyf.service.ICustomerService;
import zyf.service.ILinkManService;
import zyf.service.impl.Hb_CustomerServiceImpl;
import zyf.service.impl.LinkManServiceImpl;
import zyf.utils.Constants;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkman = new LinkMan();
	
	ILinkManService ilms = new LinkManServiceImpl();
	ICustomerService  ics = new Hb_CustomerServiceImpl();
	
	/**
	 * 添加联系人
	 * @return
	 * @throws Exception
	 */
	public String addLinkman() throws Exception{
		String sex = linkman.getLkmGender();
		if("1".equals(sex)){
			sex="男";
		}else{
			sex="女";
		}
		linkman.setLkmGender(sex);
		String custName = ServletActionContext.getRequest().getParameter("custName");
		String custNameS = ServletActionContext.getRequest().getParameter("custNameS");
		Customer byName = null;
		if(!"请选择".equals(custNameS)){
			if(!"".equals(custName)){
				byName = ics.getCustomerByName(new Customer(null,custName));
			}else{
				byName = ics.getCustomerByName(new Customer(null,custNameS));
			}
			linkman.getCstCustomers().add(byName);
		}else{
			if(!"".equals(custName)){
				byName = ics.getCustomerByName(new Customer(null,custName));
			}
			linkman.getCstCustomers().add(byName);
		}
		
		
		LinkMan addLinkMan = ilms.addLinkMan(linkman);
		System.out.println(addLinkMan);
		if(addLinkMan==null){
			return Constants.FAILED;
		}
		return Constants.ADDSUCCESS;
	}

	/**
	 * 更新指定id的联系人
	 * @return
	 * @throws Exception
	 */
	public String updateLinkman() throws Exception{
		int linkMan2 = ilms.updateLinkMan(linkman);
		if(linkMan2==1){
			return Constants.SETUPDATESUCCESS;
		}else{
			return Constants.FAILED;
		}
	}
	
	/**
	 * 展示所有的联系人
	 * @return
	 * @throws Exception
	 */
	public String listLinkMan () throws Exception{
		List<LinkMan> list = ilms.queryLinkMan();
		ServletActionContext.getRequest().setAttribute("list", list);
		System.out.println(list);
		if(list==null&&list.size()==0){
			return Constants.FAILED;
		}
		return Constants.LISTSUCCESS;
	}
	
	
	/**
	 * 查询指定id的联系人
	 * @return
	 * @throws Exception
	 */
	public String queryUpdateLinkMan() throws Exception{
		System.out.println(".............."+linkman.getLkmId());
		LinkMan manById = ilms.queryLinkManById(linkman.getLkmId());
		ServletActionContext.getRequest().getSession().setAttribute("linkId", linkman.getLkmId());
		if(manById==null){
			return Constants.FAILED;
		}
		String sex = manById.getLkmGender();
		if("男".equals(sex)){
			sex="1";
		}else{
			sex="2";
		}
		manById.setLkmGender(sex);
		List<Customer> custs = ics.getCustomerByLinkId(linkman.getLkmId());
		ServletActionContext.getRequest().setAttribute("linkman", manById);
		System.out.println(manById);
		return Constants.UPDATESUCCESS;
	}
	
	/**
	 * 根据姓名模糊查询
	 * @return
	 * @throws Exception 
	 */
	public String queryLikeLinkMan() throws Exception{
		List<LinkMan> manByNames = ilms.queryLinkManByName(linkman.getLkmName());
		ServletActionContext.getRequest().setAttribute("list", manByNames);
		System.out.println(manByNames);
		if(manByNames==null&&manByNames.size()==0){
			return Constants.FAILED;
		}
		return Constants.LISTSUCCESS;
		
	}
	
	public String deleteLinkMan() throws Exception{
		return null;
	}
	
	
	
	
	
	
	public LinkMan getLinkman() throws Exception {
		return linkman;
	}

	public void setLinkman(LinkMan linkman) {
		this.linkman = linkman;
	}


	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}

}
