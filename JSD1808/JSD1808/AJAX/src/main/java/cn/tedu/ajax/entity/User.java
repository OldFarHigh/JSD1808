package cn.tedu.ajax.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6580598179637587801L;
	
	
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private String phone;
	private String email;
	private Integer isDelete;
	private Integer department;
	
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Integer getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", phone="
				+ phone + ", email=" + email + ", isDelete=" + isDelete + ", department=" + department + "]";
	}

	
}