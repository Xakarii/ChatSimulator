package main;

//import java.awt.Frame;

//import javax.swing.JLabel;

public class Main {	
	static Server server = new Server();
	public static void main(String[] args) {
		server.Add(new Chatter("Me", server));
		server.Add(new Chatter("They", server));
		server.Add(new Chatter("Who", server));
		
	}
}
