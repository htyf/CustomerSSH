package zyf.entity;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Customer {
	private String custId;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custLinkman;
	private String custPhone;
	private String custMobile;
	private String custAddress;
	private String custZip;
	private String custFax;
	private String custWebsite;
	
	private LinkMan lkmLinkMans;
	
	/*private Set<User> users = new HashSet<User>();*/
	
	
	
	public LinkMan getLkmLinkMans() {
		return lkmLinkMans;
	}
	public void setLkmLinkMans(LinkMan lkmLinkMans) {
		this.lkmLinkMans = lkmLinkMans;
	}
	/*public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}*/
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustZip() {
		return custZip;
	}
	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}
	public String getCustFax() {
		return custFax;
	}
	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}
	public String getCustWebsite() {
		return custWebsite;
	}
	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
	
	public Customer(String custName, String custLevel, String custSource, String custLinkman, String custPhone,
			String custMobile, String custAddress, String custZip, String custFax, String custWebsite) {
		super();
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
	}
	
	
	public Customer(String custId, String custName, String custLevel, String custSource, String custLinkman,
			String custPhone, String custMobile, String custAddress, String custZip, String custFax,
			String custWebsite) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String custId) {
		this.custId = custId;
	}
	
	public Customer(String custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	
	public Customer(String custId, String custName, String custLevel, String custSource, String custLinkman,
			String custPhone, String custMobile, String custAddress, String custZip, String custFax, String custWebsite,
			LinkMan custLinkmans) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.lkmLinkMans = custLinkmans;
	}
	
	
	/*public Customer(String custId, String custName, String custLevel, String custSource, String custLinkman,
			String custPhone, String custMobile, String custAddress, String custZip, String custFax, String custWebsite,
			LinkMan custLinkmans, Set<User> users) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.lkmLinkMans = custLinkmans;
		this.users = users;
	}*/
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custLinkman=" + custLinkman + ", custPhone=" + custPhone + ", custMobile="
				+ custMobile + ", custAddress=" + custAddress + ", custZip=" + custZip + ", custFax=" + custFax
				+ ", custWebsite=" + custWebsite+ "]";
	}
	
	

}
