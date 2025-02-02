package BNU.logic.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JFrame;

import BNU.data.Message;
import BNU.logic.CustomComparator;
import BNU.logic.MessageBoardController;
import BNU.logic.service.proxy.SmartProxy;
import BNU.presentation.MessageBoardView;
import BNU.singleton.SingletonSession;

/**
 * 
 * @author Kevin
 * 
 * OBSERVER GoF Design Pattern
 * Behavioral
 * 
 * This class follows the observer design pattern because it 
 * establishes a one-to-many relationship where the program
 * observes the message board to notify a user if they
 * receive a message. When a user is on the message board
 * viewing a message thread, this observer will constantly 
 * check to see if the message thread must be updated. The subject
 * is the other user sending the message and the observer
 * essentially monitors this user because it is dependent 
 * on their behavior. The purpose of this observer is to 
 * create real-time messaging between two users.
 */
public class MessageBoardService {

	public void messageSend(String message, String from, String to) {
		SmartProxy sp = new SmartProxy();
		BigInteger i = BigInteger.valueOf(System.currentTimeMillis());
		sp.sanatizeAndSendMessage(message, from, to, i);
		// MessageBoardController.db.sendMessage(message);
	}

	public String getReceiver() {
		return SingletonSession.getInstance().getUserName();
	}

	public /* ArrayList<Message> */ String[] getAllMessagersToUser(String receiver) {

		String[] messages = removeDuplicates(MessageBoardController.db.getAllUserMessagers(receiver));

//			ArrayList<Message> finalAr = new ArrayList<>();
//			
//			for(int i = 0 ;i < messages.length; i++) {
//				finalAr.add(new Message(messages[i][0], new BigInteger(messages[i][1]), messages[i][2], messages[i][3]));
//			}
		
		ArrayList<String> removed = new ArrayList<String>(Arrays.asList(messages));
		
		removed.remove(SingletonSession.getInstance().getUserName());
		String[] finalval = new String[removed.size()];
		messages = removed.toArray(finalval);

		return messages;
	}

	public String[] removeDuplicates(String[] origArray) {

		return new HashSet<String>(Arrays.asList(origArray)).toArray(new String[0]);
	}

	public ArrayList<Message> getAllMessagesFromTo(String sender, String receiver) {
		String[][] msgs = MessageBoardController.db.getAllMessages(sender, receiver);

		ArrayList<Message> messages = new ArrayList<>();

		for (int i = 0; i < msgs.length; i++) {
			messages.add(new Message(msgs[i][0], new BigInteger(msgs[i][1]), msgs[i][2], msgs[i][3]));
		}

		Collections.sort(messages, new CustomComparator());

		return messages;
	}

	public void sendMessage(String text, String sender, String receiver, BigInteger valueOf) {
		// TODO Auto-generated method stub

	}

	public void observer(MessageBoardController mbc, String user) throws InterruptedException {
		System.out.println("---Threading----");
		JFrame mainF = mbc.mainF;
		int old = MessageBoardController.db.getNumberOfMessagesForUser(user);

		while (true) {
			int temp;
			if ((temp = MessageBoardController.db.getNumberOfMessagesForUser(user)) > old) {
				MessageBoardView.BuildMessageBoardView(mainF, mbc);
				old = temp;

			}
			Thread.sleep(3000);
		}
	}

}
