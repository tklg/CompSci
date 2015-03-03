package chatroom;

import java.io.*;
import java.net.*;

import functions.*;

/*
 * each client is assigned its own server thread
 * the thread hand;es input/output of everything
 */

public class ChatServerThread extends Thread {
	
	private static final String SPLITTER = "‡"; //double dagger character
	private static final String COLOR_SETTER = "§";
	
	private Socket socket = null;
	private ChatServer server = null;
	private int id = -1;
	private String name = null;
	private PrintWriter msgOut;
	private BufferedReader msgIn;
	
	public ChatServerThread(Socket socket, ChatServer server) {
		//super("ChatServerThread");
		this.socket = socket;
		this.server = server;
		this.id = server.getNextClientID();
		p.nl("Connection from: " + socket.toString());
	}
	public void run() {
		
		try {
			msgOut = new PrintWriter(socket.getOutputStream(), true);
			msgIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
				String input;
				String output;
				
				TextTransferProtocol ttp = new TextTransferProtocol(this); //set up ttp parsey thing
				
				if (name == null) {
					name = msgIn.readLine();
				}
				//output = ttp.processIn("login", msgIn.readLine()); //get message from input (this one is for the login alert)
				server.sendAll(name + " has joined the server");
				
				while ((input = msgIn.readLine()) != null) { //continue doing that until ends
					output = ttp.processIn(input);
					server.sendAll(name + ": " + output);
				}
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void send(String msg) {
		msgOut.println(msg);
	}
	public void leave() {
		try {
			server.sendAll(name + " has left the server");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

