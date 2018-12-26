package cn.tedu.mybatis.entity;

import java.io.Serializable;

public class Score implements Serializable{
	
	private static final long serialVersionUID = 5791549742575301192L;
	
	private Integer id;
	private Integer stu_id;
	private String subject;
	private Integer score;
	public Integer getId() {
		return id;
	}
	public Integer getStu_id() {
		return stu_id;
	}
	public String getSubject() {
		return subject;
	}
	public Integer getScore() {
		return score;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", stu_id=" + stu_id + ", subject=" + subject + ", score=" + score + "]";
	}
	
	
}