package chatroom;

import functions.*;

public class TextTransferProtocol {
	
	public String STATE = "waiting"; //idle, waiting, processing, sending, done -> idle
	private static final String SPLITTER = "‡";
	private static final String COLOR_SETTER = "§";
	
	private ChatServerThread thread;
	
	public TextTransferProtocol(ChatServerThread thread) {
		this.thread = thread; //use this for calling commands on the thread
	}

    public String processIn(String in) {
    	
    	String out = "";
    	//scan for commands and stuff here
    	
    	if (in.startsWith("/")) {
    		String[] cmd = in.substring(1, in.length() - 1).trim().split(" ");
    		p.nl("Recieved command: " + cmd);
    		thread.runCmd(cmd);
    	} else {
    		out = in.trim();
    	}
    	
    	if (out.equalsIgnoreCase("logout")) {
    		thread.leave();
    	} else {
            return out;   		
    	}
    	return null;
    }
    
	private static String sanitize(String msg) {
		return msg.trim();
	}
}
