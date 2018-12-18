package entity;
/**
 * user类
 * 用于存放从数据库重查出的数据
 * @author OldFarHigh
 *
 */
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
