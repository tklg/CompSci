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
			    for (int i = 0; i < 3; i++) {
			    	System.out.println(ips[i]);
			    }
			}
			p.nl();
			p.nl("On LAN, join the address starting with 192.168.*.*");
			p.nl("Else use the first IP in the list.");
			p.nl();
		} catch (UnknownHostException e) {

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
	
	public void sendAll(String msg) {
		for (ChatServerThread user : client) {
			user.send(msg);
		}
	}
	
	public void sendOne(int id, String msg) {
		client.get(id).send(msg);
	}
	
	private void kick(int id) {
		sendOne(id, "Kicked from server");
		client.get(id).leave();
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
