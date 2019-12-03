package BNU.logic.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import BNU.data.Message;
import BNU.logic.MessageBoardController;
import BNU.logic.service.proxy.SmartProxy;
import BNU.singleton.SingletonSession;

public class MessageBoardService {

		public void messageSend(Message message) {
			SmartProxy sp = new SmartProxy();
			sp.sanatizeAndSendMessage(message);
			//MessageBoardController.db.sendMessage(message);
		}
		
		public String getReceiver() {
			return SingletonSession.getInstance().getUserName();
		}
		
		public String[] getAllMessagersToUser(String receiver) {
			return MessageBoardController.db.getAllUserMessagers(receiver);
		}
		
		public ArrayList<Message> getAllMessagesFromTo(String sender, String receiver){
			String[][] msgs = MessageBoardController.db.getAllMessages(sender, receiver);
			
			ArrayList<Message> messages = new ArrayList<>();
			
			for(int i = 0; i < msgs.length; i++) {
				Timestamp timestamp = null; 
				try {
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				    Date parsedDate = (Date) dateFormat.parse(msgs[i][1]);
				    timestamp = new java.sql.Timestamp(parsedDate.getTime());
				} catch(Exception e) { //this generic but you can control another types of exception
				    // look the origin of excption 
				}
				if(i % 2 == 0) {
					messages.add(new Message(msgs[i][0],timestamp,msgs[i][2],msgs[i][3]));
				}else {
					messages.add(new Message(msgs[i][0],timestamp,msgs[i][3],msgs[i][2]));
				}
				
			}

			
//			messages.add(new Message(mess, new Timestamp(System.currentTimeMillis()), sender, receiver));
//			messages.add(new Message(mess1, new Timestamp(System.currentTimeMillis()), receiver, sender));
//			messages.add(new Message(mess2, new Timestamp(System.currentTimeMillis()), sender, receiver));
//			messages.add(new Message(mess3, new Timestamp(System.currentTimeMillis()), receiver, sender));
//			messages.add(new Message(mess4, new Timestamp(System.currentTimeMillis()), sender, receiver));
//			messages.add(new Message(mess5, new Timestamp(System.currentTimeMillis()), receiver, sender));
//			messages.add(new Message(mess6, new Timestamp(System.currentTimeMillis()), sender, receiver));
//			messages.add(new Message(mess7, new Timestamp(System.currentTimeMillis()), receiver, sender));
			
			return messages;
		}
	
}
