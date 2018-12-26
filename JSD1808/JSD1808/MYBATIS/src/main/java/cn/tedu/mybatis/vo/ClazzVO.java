package cn.tedu.mybatis.vo;

import java.io.Serializable;
import java.util.List;

import cn.tedu.mybatis.entity.Student;

public class ClazzVO implements Serializable {
	
	private static final long serialVersionUID = 4848980925565856292L;
	
		private  Integer classId;
		private  String  className;
		private  List<Student> student;
		public Integer getClassId() {
			return classId;
		}
		public String getClassName() {
			return className;
		}
		public List<Student> getStudent() {
			return student;
		}
		public void setClassId(Integer classId) {
			this.classId = classId;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public void setStudent(List<Student> student) {
			this.student = student;
		}
		@Override
		public String toString() {
			return "ClazzVO [classId=" + classId + ", className=" + className + ", student=" + student + "]";
		}
		
		
		
}
