package chatroom;

import java.io.*;
import java.net.*;
import functions.*;

public class ChatServer {
	
	public static void main(String[] args) {
		
		int port = Integer.parseInt(args[0]);
		
		try (
		
			ServerSocket sSocket = new ServerSocket(port); //set up the server socket
			Socket cSocket = new ServerSocket(port).accept(); //wait for incoming client connections
			
			PrintWriter msgOut = new PrintWriter(cSocket.getOutputStream(), true);
			BufferedReader msgIn = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			    
		) {
			
			String input, output;
			
			TextTransferProtocol ttp = new TextTransferProtocol(); //set up ttp
			
			output = ttp.processIn(msgIn); //get message from input
			
			msgOut(output); //print message 
			
			while ((input = kb.readString()) != null) { //continue doing that until ends
				output = ttp.processIn(msgIn);
				msgOut(output);
				if (output.equalsIgnoreCase("logoff")) break; //logoff command ends loop
			}
			
			
			
		} catch (Exception e) {
			p.nl("Error: " + e);
		}
		
	}

}
