package zyf.entity;

import java.util.HashSet;
import java.util.Set;

public class LinkMan {
	private String lkmId;
	private String lkmName;
	private String lkmPhone;
	private String lkmGender;
	private String lkmMobile;
	private Set<Customer> cstCustomers = new HashSet<Customer>();
	
	public Set<Customer> getCstCustomers() {
		return cstCustomers;
	}
	public void setCstCustomers(Set<Customer> cstCustomers) {
		this.cstCustomers = cstCustomers;
	}
	public String getLkmId() {
		return lkmId;
	}
	public void setLkmId(String lkmId) {
		this.lkmId = lkmId;
	}
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}
	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}
	public String getLkmGender() {
		return lkmGender;
	}
	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}
	public String getLkmMobile() {
		return lkmMobile;
	}
	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}
	public LinkMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinkMan(String lkmId, String lkmName, String lkmPhone, String lkmGender, String lkmMobile,
			Set<Customer> cstCustomer) {
		super();
		this.lkmId = lkmId;
		this.lkmName = lkmName;
		this.lkmPhone = lkmPhone;
		this.lkmGender = lkmGender;
		this.lkmMobile = lkmMobile;
		this.cstCustomers = cstCustomer;
	}
	@Override
	public String toString() {
		return "LinkMan [lkmId=" + lkmId + ", lkmName=" + lkmName + ", lkmPhone=" + lkmPhone + ", lkmGender="
				+ lkmGender + ", lkmMobile=" + lkmMobile + ", cstCustomers=" + cstCustomers + "]";
	}
	
	
	
	

	
	
}
