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
	private static final String CS = "§";
	
	private Socket socket = null;
	private ChatServer server = null;
	private int id = -1;
	public String name = null;
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
				server.sendAll(CS + "e" + name + " has joined the server" + CS + "f");
				
				while ((input = msgIn.readLine()) != null) { //continue doing that until ends
					output = ttp.processIn(input);
					if (output != null) server.sendAll(CS + "2" + name + CS + "f: " + output);
				}
				socket.close();
				
			} catch (Exception e) {
				//e.printStackTrace();
				p.nl("Lost connection to user: " + name);
			}
	}
	
	public void send(String msg) {
		msgOut.println(msg);
	}
	public void leave() {
		try {
			server.sendAll(CS + "e" + name + " has left the server" + CS + "f");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean startVote(String type, int starter, int target, String desc) {
		if (server.startVote(type, starter, target, desc)) {
			return true;
		}
		return false;
	}
	public boolean startVote(String type, int starter, String desc) {
		if (server.startVote(type, starter, desc)) {
			return true;
		}
		return false;
	}
	public void vote(int voter, int option) {
		server.vote(voter, option);
	}
	private int lastUserPMd = -1;
	public void runCmd(String[] cmd) {
		String cmdName = cmd[0].toLowerCase().trim();
		String msg;
		int target;
		switch (cmdName) {
		case "votekick":
			server.sendOne(server.getClientID(name), CS + "4/vote and /votekick are unimplemented.");
			break;
			/*if (cmd.length != 2) {
				server.sendOne(server.getClientID(name), CS + "4votekick syntax: /votekick <user>");
				break;
			}
			target = server.getClientID(cmd[1]); //get id of user name
			String starter = name;
			if (target == -1) {
				server.sendOne(server.getClientID(name), CS + "4User '" + cmd[1] + "' is not online");;
			} else {
				startVote("kick", server.getClientID(starter), target, "kick");
				vote(server.getClientID(starter), 1); //voter also votes yes
			}
			break;*/
		case "vote":
			server.sendOne(server.getClientID(name), CS + "4/vote and /votekick are unimplemented.");
			break;
			/*if (cmd.length != 2) {
				server.sendOne(server.getClientID(name), CS + "4vote syntax: /vote <yes | no>");
				break;
			}
			int voter = server.getClientID(name);
			if (cmd[1].equalsIgnoreCase("yes")) {
				server.vote(voter, 1);
			} else if (cmd[1].equalsIgnoreCase("no")) {
				server.vote(voter, 0);
			} else if (cmd[1].equalsIgnoreCase("end")) {
				server.sendOne(server.getClientID(name), CS + "4Ending current vote and tallying results.");
			} else {
				server.sendOne(server.getClientID(name), CS + "4Please vote \"yes\" or \"no\"");
			}
			break;*/
		case "me":
		case "emote":
			if (cmd.length <= 1) {
				server.sendOne(server.getClientID(name), CS + "4me syntax: /me <message>");
				break;
			}
			msg = "";
			for (int i = 1; i < cmd.length; i++) {
				msg += cmd[i] + " ";
			}
			server.sendAll(CS + "f> " + CS + "2" + name + CS + "f " + msg);
			break;
		case "msg":
		case "message":
			if (cmd.length < 3) {
				server.sendOne(server.getClientID(name), CS + "4msg syntax: /msg <user> <message>");
				break;
			}
			msg = "";
			for (int i = 2; i < cmd.length; i++) {
				msg += cmd[i] + " ";
			}
			target = server.getClientID(cmd[1]);
			lastUserPMd = target;
			if (target == -1) {
				server.sendOne(server.getClientID(name), CS + "4User '" + cmd[1] + "' is not online");
			} else {
				//server.sendOne(server.getClientID(name), target, CS + "d" + msg);
				server.sendOne(target, CS + "d" + name + " -> you: " + msg);
				server.sendOne(server.getClientID(name), CS + "dme -> " + cmd[1] + ": " + msg);
			}
			break;
		case "r":
		case "reply":
			if (cmd.length < 2) {
				server.sendOne(server.getClientID(name), CS + "4reply syntax: /r <message>");
				break;
			}
			msg = "";
			for (int i = 1; i < cmd.length; i++) {
				msg += cmd[i] + " ";
			}
			target = lastUserPMd;
			if (target == -1) {
				server.sendOne(server.getClientID(name), CS + "4User '" + server.getClientName(target) + "' is not online");;
			} else {
				//server.sendOne(server.getClientID(name), target, CS + "d" + msg);
				server.sendOne(target, CS + "d" + name + " -> you: " + msg);
				server.sendOne(server.getClientID(name), CS + "dme -> " + server.getClientName(target) + ": " + msg);
			}
			break;
		case "help":
		case "?":
			if (cmd.length != 1) {
				server.sendOne(server.getClientID(name), CS + "4help syntax: /help");
				break;
			}
			server.sendOne(server.getClientID(name), CS + "aAvailable commands: /me /emote /msg /message /r /reply /help /?");
			break;
		case "who":
		case "list":
			if (cmd.length != 1) {
				server.sendOne(server.getClientID(name), CS + "4user list syntax: /list");
				break;
			}
			server.sendOne(server.getClientID(name), CS + "aUsers online: ");
			break;
		default:
			server.sendOne(server.getClientID(name), CS + "4The command you entered does not exist!");
			break;
		}
	}
}

