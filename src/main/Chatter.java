package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Chatter extends JFrame implements ISend, IReceive, ActionListener {
	JPanel panel;
	JLabel label;
	JButton button;
	JTextArea t;
	JEditorPane history;
	String name;
	String msg;
	Server srv;
	
	public void actionPerformed(JLabel l, ActionEvent e) {
		label.setText("Don't do that again");
	}
	public void actionPerformed(ActionEvent txt) {
		//this.Send(name, msg); 
		System.out.println("ActionEvent txt performed!");
	}
	public void Notify(String msg) {
		label.setText(msg);
	}
	public void Send(String From, String Message) {srv.Send(From, Message);};
	public void Receive(String From, String Message) {
		if (history.getText() == "Message History!") {
			history.setText(From + " : " + Message);
			}
			else history.setText(history.getText() + "\n " + From + " : " + Message);
	};
		
	public Chatter(String n, Server server) {
		//JFrame frame = new JFrame("My frame");  Form is the JFrame now
		name = n;
		srv = server;
		this.setSize(500, 600);
		this.setLocationRelativeTo(button);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		history = new JEditorPane();
		history.setText("Message History!");
		JScrollPane j = new JScrollPane(history);
		panel.add(j, BorderLayout.CENTER);
		j.setBounds(5, 5, 100, 100);
		
		button = new JButton("Send Message");
		JTextArea t = new JTextArea(); 
		panel.add(t);
		button.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				Send(name, t.getText());
			}
		}); 
		
		panel.add(button);
		this.add(panel);
		this.setVisible(true);
	}
	
}
