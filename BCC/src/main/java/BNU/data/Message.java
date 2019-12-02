package BNU.data;

import java.sql.Timestamp;

public class Message {

	String text;
	Timestamp time;
	String sender;
	String receiver;
	
	public Message(String text, Timestamp time, String sender, String receiver) {
		super();
		this.text = text;
		this.time = time;
		this.sender = sender;
		this.receiver = receiver;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
