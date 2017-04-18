package zyf.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String userid;
	private String username;
	private String password;
	private String txtcode;
	
	/*private Set<Customer> custs = new HashSet<Customer>();*/
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


/*	public Set<Customer> getCusts() {
		return custs;
	}



	public void setCusts(Set<Customer> custs) {
		this.custs = custs;
	}*/



	public User(String username, String password, String txtcode) {
		super();
		this.username = username;
		this.password = password;
		this.txtcode = txtcode;
	}



	public User(String userid, String username, String password, String txtcode) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.txtcode = txtcode;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username) {
		super();
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTxtcode() {
		return txtcode;
	}

	public void setTxtcode(String txtcode) {
		this.txtcode = txtcode;
	}







	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", txtcode=" + txtcode
				+ "]";
	}




	
	
	
	

}
