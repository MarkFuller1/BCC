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

		public void messageSend(String message, String from, String to) {
			SmartProxy sp = new SmartProxy();
			BigInteger i = BigInteger.valueOf(System.currentTimeMillis());
			sp.sanatizeAndSendMessage(message, from, to, i);
			//MessageBoardController.db.sendMessage(message);
		}
		
		public String getReceiver() {
			return SingletonSession.getInstance().getUserName();
		}
		
		public /*ArrayList<Message>*/ String[] getAllMessagersToUser(String receiver) {
			
			String[] messages = MessageBoardController.db.getAllUserMessagers(receiver);
			
			
//			ArrayList<Message> finalAr = new ArrayList<>();
//			
//			for(int i = 0 ;i < messages.length; i++) {
//				finalAr.add(new Message(messages[i][0], new BigInteger(messages[i][1]), messages[i][2], messages[i][3]));
//			}
			
			return messages;
		}
		
		public ArrayList<Message> getAllMessagesFromTo(String sender, String receiver){
			String[][] msgs = MessageBoardController.db.getAllMessages(sender,receiver);
			
			ArrayList<Message> messages = new ArrayList<>();
			
			for(int i = 0; i < msgs.length; i++) {
				
				if(i % 2 == 0) {
					messages.add(new Message(msgs[i][0],new BigInteger("1"),msgs[i][2],msgs[i][3]));
				}else {
					messages.add(new Message(msgs[i][0],new BigInteger("1"),msgs[i][3],msgs[i][2]));
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

		public void sendMessage(String text, String sender, String receiver, BigInteger valueOf) {
			// TODO Auto-generated method stub
			
		}

		public void observer(MessageBoardController mbc, String user) {
			int old = mbc.db.getNumberOfMessagesForUser(user);
			
			while(true) {
				int temp;
				if((temp = mbc.db.getNumberOfMessagesForUser(user)) > old) {
					mbc.dispatchBuilder( mbc.mainF);
					old = temp;
					
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	
}
