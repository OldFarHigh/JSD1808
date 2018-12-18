package dayTest_1019;

/**
 * 员工类，每个实例用于表示一个员工信息
 * 
 * @author OldFarHigh
 *
 */
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;
	private double salary;
	
	public Emp(int id, String name, int age, String gender, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary + "]";
	}

}
