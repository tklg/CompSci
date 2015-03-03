package chatroom;

import java.io.*;
import java.net.*;

import functions.*;

public class ChatClient implements Runnable {
	
	private static final String SPLITTER = "‡";
	private static final String COLOR_SETTER = "§";
	private static PrintWriter msgOut;
	private static BufferedReader msgIn;
	private static ChatClientGUI g;
	public static String host, user;
	public static int port;
		
	public static void main(String[] args) {
		new Thread(new ChatClient()).start();
	}
	
	public void run() {
		g = new ChatClientGUI(this);
		while(!g.displaySettings()) {
			//wait
		}
		g.displayMain();
		
		p.nl("Starting ChatClient");
		p.nl("Connecting to " + host + " on port " + port);
		
		try {
			Socket sSocket = new Socket("localhost", port);
			msgOut = new PrintWriter(sSocket.getOutputStream(), true);
			msgIn = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));	
		} catch (Exception e) {
			p.ne("Error: Failed to connect");
			e.printStackTrace();
			System.exit(-1); //if fails to connect, quit
		}
		try {
			
			String msgFrom;
			/*p.nl("Set username: ");
			String user = kb.readString();*/
			
			msgOut.println(user); //send the username as the client's first message to the server
			
			while ((msgFrom = msgIn.readLine()) != null) { //read response from server
				
				p.nl(msgFrom); //push to chatbox
				g.pushToChat(msgFrom);
				
			}	
		} catch (Exception e) {
			p.ne("Error: Failed to send/recieve");
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		String msgTo = msg;
		//msgTo = kb.readString(); //read user input -- have this so that it sends when user presses a button or something
		if (msgTo != null) {
			msgOut.println(msgTo); //send input to server
		}
	}
	
	private static String sanitize(String msg) {
		return msg.trim();
	}
	private static void printColor(String msg) {
		
	}

}
