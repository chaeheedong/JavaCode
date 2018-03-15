package ioEx.userVO;

import java.io.Serializable;

public class UserVO implements Serializable {

	// Field
	private int no;
	private String name;

	// Constructor
	public UserVO() {
	}

	public UserVO(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	// Method
	// setter method
	public final void setNo(int no) {
		this.no = no;
	}

	public final void setName(String name) {
		this.name = name;
	}

	// getter method
	public final int getNo() {
		return no;
	}

	public final String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
