package models;

import java.util.Arrays;

public class Student {
	
	public Student(String name,  String username, String password) {//String[] classes,
		super();
		this.name = name;
		//this.classes = classes;
		this.username = username;
		this.password = password;
	}
	
	String name;
	//String classes[];
	String username;
	String password;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + Arrays.hashCode(classes);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
//		if (!Arrays.equals(classes, other.classes))
//			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getClasses() {
//		String classes = "";
//		
////		for(String classNum: this.classes) {
////			classes += classNum + ":";
////		}
//		return classes;
//	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", classes=" +  ", username=" + username
				+ ", password=" + password + "]";//Arrays.toString(classes) +
	}
//	public void setClasses(String[] classes) {
//		this.classes = classes;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
