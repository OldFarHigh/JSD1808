package cn.tedu.ajax.entity;

import java.io.Serializable;

public class ResponseResult implements Serializable{

	private static final long serialVersionUID = 2466622190650549542L;

	private Integer state;
	private String message;
	public Integer getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + "]";
	}

	
}
