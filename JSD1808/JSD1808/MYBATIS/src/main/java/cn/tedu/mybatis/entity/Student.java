package cn.tedu.mybatis.entity;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -135237606609739118L;
	
	private Integer id;
	private String name;
	private Integer age;
	private Integer class_id;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", class_id=" + class_id + "]";
	}
	
	
	
}
