package chatroom;

import java.io.*;
import java.net.*;
import java.util.*;

import functions.*;

public class ChatServer implements Runnable {
	
	/*
	 * TODO:
	 * Add server command parser including:
	 	/pex <promote | demote> for temporary chat mods
	 */
	
	private static ArrayList<ChatServerThread> client = new ArrayList<ChatServerThread>();
	private static int numClients = 0;
	public static int port = 0;
	private static final String CS = "§";
	private static ChatServerGUI g;
	
	public static void main(String[] args) {
		new Thread(new ChatServer()).start();
	}
	public ChatServer() {
		//port = findFreePort();
		port = 25565;
	}
	
	public void run() {
		g = new ChatServerGUI(this);
		g.displayMain();
		p.nl("Starting ChatServer on port " + port);
		g.pushToChat("[INFO] Starting ChatServer on port " + port);
		p.nl();
		p.nl("This computer's IP Addresses are:");
		g.pushToChat("[INFO] This computer's IP Addresses are:");
		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
			if (ips != null ) {
			    for (int i = 0; i < ips.length; i++) {
			    	System.out.println(ips[i]);
			    	g.pushToChat("[INFO] \t" + ips[i]);
			    }
			}
			p.nl();
			p.nl("On LAN, join the address starting with 192.168.*.*");
			p.nl("If it doesn't exist, use the first IP in the list.");
			g.pushToChat("[INFO] On LAN, join the address starting with 192.168.*.*");
			g.pushToChat("[INFO] If it doesn't exist, use the first IP in the list.");
			p.nl();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		boolean listening = true;
		try (ServerSocket sSocket = new ServerSocket(port)) {
			p.nl("Waiting for incoming connections");
			g.pushToChat("[INFO] Waiting for incoming connections");
            while (listening) {
	            client.add(new ChatServerThread(sSocket.accept(), this));
	            client.get(client.size() - 1).start();
	            numClients++;
	        }
	    } catch (Exception e) {
            p.ne("Could not listen on port " + port);
            g.pushToChat("[ERROR] Could not bind to port! Is another server already running on that port?");
            e.printStackTrace();
            //System.exit(-1);
        }
	}
	
	public int getNextClientID() {
		return numClients;
	}
	public void removeClient(int id) {
		//client.remove(id);
	}
	public static int getClientID(String name) {
		for (int i = 0; i < client.size(); i++) {
			if (client.get(i).name.equalsIgnoreCase(name)) return i;
		}
		return -1;
	}
	public static String getClientName(int id) {
		return client.get(id).name;
	}
	
	public static void sendAll(String msg) {
		if (msg != null) {
			for (ChatServerThread user : client) {
				user.send(msg + CS + "f");
			}
			p.nl(msg);
			g.pushToChat(ChatServerFunctions.parseColor(msg + CS + "f") + ChatServerFunctions.closeSpans());
		}
	}
	
	public static void sendOne(int starter, int target, String msg) { //used for pms
		if (msg != null) {
			client.get(target).send(msg + CS + "f"); //set color code to putple for all of these
		}
		p.nl(client.get(starter).name + " -> " + client.get(target).name + ": " + msg);
		g.pushToChat(ChatServerFunctions.parseColor(msg + CS + "f") + ChatServerFunctions.closeSpans());
	}
	public static void sendOne(int target, String msg) { //used for server -> user (command responses)
		if (msg != null) {
			client.get(target).send(msg + CS + "f");
		}
		p.nl("Server -> " + client.get(target).name + ": " + msg);
		g.pushToChat("Server -> " + ChatServerFunctions.parseColor(msg + CS + "f") + ChatServerFunctions.closeSpans());
	}
	
	public static void kick(int starter, int target) {
		sendOne(starter, target, CS + "4Kicked from server");
		sendOne(starter, target, "kick");
		sendAll(CS + "c" + client.get(starter).name + " has kicked " + client.get(target).name + " from the server");
		//g.pushToChat(ChatServerFunctions.parseColor(CS + "c" + client.get(starter).name + " has kicked " + client.get(target).name + " from the server") + ChatServerFunctions.closeSpans());
		client.get(target).leave();
	}
	public static void kick(int target) {
		sendOne(target, CS + "4Kicked from server");
		sendOne(target, "kick");
		sendAll(CS + "c" + client.get(target).name + " has been kicked from the server");
		//g.pushToChat(ChatServerFunctions.parseColor(CS + "c" + client.get(target).name + " has been kicked from the server") + ChatServerFunctions.closeSpans());
		client.get(target).leave();
	}
	public static void kick(int target, String reason) {
		sendOne(target, CS + "4Kicked " + reason);
		sendOne(target, "kick");
		sendAll(CS + "c" + client.get(target).name + " has been kicked " + reason);
		//g.pushToChat(ChatServerFunctions.parseColor(CS + "c" + client.get(target).name + " has been kicked " + reason) + ChatServerFunctions.closeSpans());
		client.get(target).leave();
	}
	public static void kickAll() {
		for (int i = 0; i < client.size(); i++) {
			client.get(i).leave();
			sendAll("kick");
		}
	}
	private boolean voting = false;
	private ChatVote vote;
	public boolean startVote(String type, int starter, int target, String desc) {
		if (!voting) {
			vote = new ChatVote(starter, type, target);
			sendAll(CS + "c" + client.get(starter).name + " has voted to " + desc + client.get(target).name);
			p.nl(client.get(starter).name + " has voted to " + desc + client.get(target).name);
			voting = true;
			return true;
		}
		return false;
	}
	public boolean startVote(String type, int starter, String desc) {
		if (!voting) {
			vote = new ChatVote(starter, type, desc);
			sendAll(CS + "c" + client.get(starter).name + " has voted to " + desc);
			p.nl(client.get(starter).name + " has voted to " + desc);
			voting = true;
			return true;
		}
		return false;
	}
	public void vote(int voter, int option) {
		sendAll(CS + "c" + client.get(voter).name + " has voted " + ((option == 0) ? "no" : "yes"));
		p.nl(client.get(voter).name + " has voted " + ((option == 0) ? "no" : "yes"));
		vote.addVote(option);
		if (vote.totalVotes() == client.size()) {
			endVote();
		}
	}
	private void endVote() {
		voting = false;
	}
	public static void pushToChat(String msg) {
		g.pushToChat(ChatServerFunctions.parseColor(msg) + ChatServerFunctions.closeSpans());
	}
	public static void promoteClient(int id) {
		
	}
	public static void promoteClient(int id, int alvl) {
		
	}
	public static void demoteClient(int id) {
		
	}
	public static void demoteClient(int id, int alvl) {
		
	}
	
	private static int findFreePort() {
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			int port = socket.getLocalPort();
			try {
				socket.close();
			} catch (IOException e) {
			}
			return port;
		} catch (IOException e) { 
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		throw new IllegalStateException("Could not find a free TCP/IP port");
	}
	
}
