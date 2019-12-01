package BNU.data;

import java.sql.Timestamp;

public class Review {

	String description;
	Integer votes;
	Timestamp time;
	String user;
	String Professor;
	String Classes;
	Integer teachingAbility;
	Integer helpfulness;
	Integer workload;
	
	
	public Review(String description, Timestamp time, String user, String professor, 
			String class1, Integer teachingAbility, Integer helpfulness, Integer workload) {
		super();
		this.description = description;
		this.votes = 0;
		this.time = time;
		this.user = user;
		Professor = professor;
		Classes = class1;
	    this.teachingAbility = teachingAbility;
	    this.helpfulness = helpfulness;
	    this.workload = workload;
	}
	
	public Review(String description, Timestamp time, String user, String professor, String class1) {
		super();
		this.description = description;
		this.votes = 0;
		this.time = time;
		this.user = user;
		Professor = professor;
		Classes = class1;
	}
	
	public String getProfessor() {
		return Professor;
	}
	public void setProfessor(String professor) {
		Professor = professor;
	}
	
	public String getClasses() {
		return Classes;
	}
	public void setClasses(String class1) {
		Classes = class1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public Integer getTeachingAbility() {
		return teachingAbility;
	}

	public void setTeachingAbility(Integer teachingAbility) {
		this.teachingAbility = teachingAbility;
	}

	public Integer getHelpfulness() {
		return helpfulness;
	}

	public void setHelpfulness(Integer helpfulness) {
		this.helpfulness = helpfulness;
	}

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

	@Override
	public String toString() {
		return "Review [description=" + description + ", time=" + time + ", user=" + user + ", Professor=" + Professor
				+ ", Classes=" + Classes + ", teachingAbility=" + teachingAbility + ", helpfulness=" + helpfulness
				+ ", workload=" + workload + "]";
	}
	
	
}
