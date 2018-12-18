package bean;

public class User {
	private String username;
	private int age;
	private String[] interest;
	
	private String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getUsername() {
		return username;
	}
	public int getAge() {
		return age;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
