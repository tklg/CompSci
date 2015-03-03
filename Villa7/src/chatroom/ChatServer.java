package chatroom;

import java.io.*;
import java.net.*;
import java.util.*;

import functions.*;

public class ChatServer implements Runnable {
	
	private static ArrayList<ChatServerThread> client = new ArrayList<ChatServerThread>();
	private static int numClients = 0;
	private static int port = 0;
	
	public static void main(String[] args) {
		new Thread(new ChatServer()).start();
	}
	public ChatServer() {
		port = findFreePort();
	}
	
	public void run() {
		p.nl("Starting ChatServer on port " + port);
		p.nl();
		p.nl("This computer's IP Addresses are:");
		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
			if (ips != null ) {
			    for (int i = 0; i < ips.length; i++) {
			    	System.out.println(ips[i]);
			    }
			}
			p.nl();
			p.nl("On LAN, join the address starting with 192.168.*.*");
			p.nl("If it doesn't exist, use the first IP in the list.");
			p.nl();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		boolean listening = true;
		try (ServerSocket sSocket = new ServerSocket(port)) {
			p.nl("Waiting for incoming connections");
            while (listening) {
	            client.add(new ChatServerThread(sSocket.accept(), this));
	            client.get(numClients).start();
	            numClients++;
	            p.nl("Number of connected clients: " + numClients);
	        }
	    } catch (Exception e) {
            p.ne("Could not listen on port " + port);
            e.printStackTrace();
            //System.exit(-1);
        }
	}
	
	public int getNextClientID() {
		return numClients;
	}
	public int getClientID(String name) {
		for (int i = 0; i < client.size(); i++) {
			if (client.get(i).name.equalsIgnoreCase(name)) return i;
		}
		return -1;
	}
	
	public void sendAll(String msg) {
		if (msg != null) {
			for (ChatServerThread user : client) {
				user.send(msg);
			}
		}
	}
	
	public void sendOne(int starter, int target, String msg) {
		if (msg != null) {
			client.get(target).send(client.get(starter).name + " -> you:" + msg);
		}
	}
	
	private void kick(int starter, int target) {
		sendOne(starter, target, "Kicked from server");
		sendAll(client.get(starter).name + " has kicked " + client.get(target).name + " from the server");
		client.get(target).leave();
	}
	private boolean voting = false;
	private ChatVote vote;
	public boolean startVote(String type, int starter, int target) {
		if (!voting) {
			vote = new ChatVote(starter, type, target);
			sendAll(client.get(starter).name + " has voted to kick " + client.get(target).name);
			voting = true;
			return true;
		}
		return false;
	}
	public boolean startVote(String type, int starter, String desc) {
		if (!voting) {
			vote = new ChatVote(starter, type, desc);
			sendAll(client.get(voter).name + " has voted " + ((option == 0) ? "no" : "yes"));
			voting = true;
			return true;
		}
		return false;
	}
	public void vote(int voter, int option) {
		sendAll(client.get(voter).name + " has voted " + ((option == 0) ? "no" : "yes"));
		vote.addVote(option);
		if (vote.totalVotes() == client.size()) {
			endVote();
		}
	}
	private void endVote() {
		voting = false;
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
