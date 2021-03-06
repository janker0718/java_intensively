package cc.janker.javaIntensively.io.decode;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private int userID;
	
	private String name;
	
	private int age;
	
	public UserInfo buildUserName(String userName){
		this.userName = userName;
		return this;
	}
	
	public UserInfo buildUserID(int userID){
		this.userID = userID;
		return this;
	}
	
	public final String getUserName(){
		return userName;
	}
	
	public final void setUserName(String userName){
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	public byte[] codeC() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userID);
		buffer.flip();
		value =null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	public byte[] codeC(ByteBuffer buffer) {
		buffer.clear();
		//ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userID);
		buffer.flip();
		value =null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
