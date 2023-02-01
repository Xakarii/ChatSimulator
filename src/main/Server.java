package main;

/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
import java.util.ArrayList;

public class Server implements ISend {
	
	private ArrayList<IReceive> Chatters = new ArrayList<>();
	
	public void Add(IReceive x) { Chatters.add(x); }
	
	public void Send(String From, String Message) {
		for (IReceive Chatter : Chatters) Chatter.Receive(From, Message);
	} 
}
