package BNU.logic.service;

import java.math.BigInteger;
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
			sp.sanatizeAndSendMessage(message, message.getSender(), message.getReceiver(), Long.toString(System.currentTimeMillis()));
			//MessageBoardController.db.sendMessage(message);
		}
		
		public String getReceiver() {
			return SingletonSession.getInstance().getUserName();
		}
		
		public String[] getAllMessagersToUser(String receiver) {
			
			String[][] messages = MessageBoardController.db.getAllMessages(receiver);
			
			Message[] finalData;
			
			finalData = new Message[messages.length];

			for (int i = 0; i < messages.length; i++) {
			    finalData[i] = new Message(messages[i][0], new BigInteger(messages[i][1]), messages[i][2], messages[i][3]);
			}
			
			return finalData;
		}
		
		public ArrayList<Message> getAllMessagesFromTo(String sender, String receiver){
			String[][] msgs = MessageBoardController.db.getAllMessages(receiver);
			
			ArrayList<Message> messages = new ArrayList<>();
			
			for(int i = 0; i < msgs.length; i++) {
				
				if(i % 2 == 0) {
					messages.add(new Message(msgs[i][0],new BigInteger("1"),msgs[i][2],msgs[i][3]));
				}else {
					messages.add(new Message(msgs[i][0],new BigInteger("1"),msgs[i][3],msgs[i][2]));
				}
			}

			
			return messages;
		}
	
}
