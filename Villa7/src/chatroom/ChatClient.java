package chatroom;

import java.io.*;
import java.net.*;

import functions.*;

public class ChatClient implements Runnable {
	
	private static final String SPLITTER = "�";
	private static final String CS = "�";
	private static PrintWriter msgOut;
	private static BufferedReader msgIn;
	private static ChatClientGUI g;
	public static String host, user;
	public static int port;
	private static int numCloseSpans = 0;
	private boolean connected = false, waitingForReconnectConfirm = false;
		
	public static void main(String[] args) {
		new Thread(new ChatClient()).start();
	}
	
	public void run() {
		g = new ChatClientGUI(this);
		boolean running = true;
		while (running) {
			while (!connected) {
				while(!g.displaySettings()) {
					//wait
				}
				connected = true;
			}
			while (connected && !waitingForReconnectConfirm) {
				g.displayMain();
				
				p.nl("Starting ChatClient");
				p.nl("Connecting to " + host + " on port " + port);
				
				try {
					Socket sSocket = new Socket(host, port);
					msgOut = new PrintWriter(sSocket.getOutputStream(), true);
					msgIn = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
					try {
						
						String msgFrom;
						
						msgOut.println(user); //send the username as the client's first message to the server
						
						while ((msgFrom = msgIn.readLine()) != null) { //read response from server
			
							if (msgFrom.equalsIgnoreCase("kick"+CS+"f")) {
								p.ne("you were kicked");
								//g.pushToChat(parseColor(CS+"cYou have been kicked") + closeSpans());
								sSocket.close();
								waitingForReconnectConfirm = true;
							} else {
								//p.nl(msgFrom);
								g.pushToChat(parseColor(msgFrom) + closeSpans());
							}							
						}	
					} catch (Exception e) {
						p.ne("Error: Failed to send/recieve");
						g.pushToChat("Lost connection to server: Connection Reset");
						g.pushToChat("Type /retry to go back to the setup window.");
						waitingForReconnectConfirm = true;
						e.printStackTrace();
					}
				} catch (Exception e) {
					p.ne("Error: Failed to connect");
					e.printStackTrace();
					//System.exit(-1); //if fails to connect, quit
					g.pushToChat("Error: failed to connect");
					g.pushToChat("Type /retry to go back to the setup window.");
					waitingForReconnectConfirm = true;
				}
			}
		}
	}
	
	public void send(String msg) {
		String msgTo = msg;
		//msgTo = kb.readString(); //read user input -- have this so that it sends when user presses a button or something
		if (msgTo != null) {
			if (waitingForReconnectConfirm && msgTo.equalsIgnoreCase("/retry")) {
				connected = false;
				waitingForReconnectConfirm = false;
			} else {
				msgOut.println(msgTo); //send input to server
			}
		}
	}
	
	private static String sanitize(String msg) {
		return msg.trim();
	}
	
	private static String parseColor(String msg) { //this method uses bad/malformed HTML BUT IT WORKS
		if (msg.contains(CS)) {
			msg = msg.replaceAll(CS+"a", "<span style=\"color: #8afb17\">")
			 .replace(CS+"b", "<span style=\"color: #00ffff\">")
			 .replace(CS+"c", "<span style=\"color: #e55451\">")
			 .replace(CS+"d", "<span style=\"color: #ff55ff\">")
			 .replace(CS+"e", "<span style=\"color: #fff380\">")
			 .replace(CS+"f", "<span style=\"color: #ffffff\">")
			 .replace(CS+"1", "<span style=\"color: #0000a0\">")
			 .replace(CS+"2", "<span style=\"color: #348017\">")
			 .replace(CS+"3", "<span style=\"color: #008080\">")
			 .replace(CS+"4", "<span style=\"color: #9f000f\">")
			 .replace(CS+"5", "<span style=\"color: #6c2dc7\">")
			 .replace(CS+"6", "<span style=\"color: #d4a017\">")
			 .replace(CS+"7", "<span style=\"color: #837e7c\">")
			 .replace(CS+"8", "<span style=\"color: #555555\">")
			 .replace(CS+"9", "<span style=\"color: #1f45fc\">")
			 .replace(CS+"0", "<span style=\"color: #000000\">")
			 .replace(CS+"l", "<span style=\"font-weight: bold\">") //bold
			 .replace(CS+"o", "<span style=\"font-style: italic\">") //italics
			 .replace(CS+"r", "<span style=\"font-weight: normal; font-style: normal\">"); //normal text
			numCloseSpans = msg.split(CS).length - 1;
		} else {
			//nothing
		}
		return msg;
	}
	private static String closeSpans() { //I THINK THIS FIXES IT MAYBE KIND OF NOT REALLY
		String ret = "";
		for (int i = 0; i < numCloseSpans; i++) {
			ret += "</span>";
		}
		return ret;
	}

}
