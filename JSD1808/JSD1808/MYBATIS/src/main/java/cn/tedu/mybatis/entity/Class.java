package cn.tedu.mybatis.entity;

import java.io.Serializable;

public class Class implements Serializable{

	private static final long serialVersionUID = -5160336785972301499L;
	
		private Integer id;
		private String name;
		public Integer getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Class [id=" + id + ", name=" + name + "]";
		}
		
}
