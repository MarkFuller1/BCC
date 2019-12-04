package BNU.logic;

import java.util.Comparator;

import BNU.data.Message;

public class CustomComparator implements Comparator<Message> {
    @Override
    public int compare(Message o1, Message o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
