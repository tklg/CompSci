package chatroom;

public class ChatServerFunctions {
	
	private static final String CS = "§";
	
	static int numCloseSpans = 0;
	static String parseColor(String msg) { //this method uses bad/malformed HTML BUT IT WORKS I THINK
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
			 .replace(CS+"0", "<span style=\"color: #000000\">");
			numCloseSpans = msg.split(CS).length - 1;
		} else {
			//nothing
		}
		return msg;
	}
	static String closeSpans() { //I THINK THIS FIXES IT MAYBE
		String ret = "";
		for (int i = 0; i < numCloseSpans; i++) {
			ret += "</span>";
		}
		return ret;
	}
	/*public void runCmd(String[] cmd) {
		String cmdName = cmd[0].toLowerCase().trim();
		String msg;
		int target;
		switch (cmdName) {
		case "votekick":
			server.sendOne(server.getClientID(name), CS + "4/vote and /votekick are unimplemented.");
			break;
			if (cmd.length != 2) {
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
			break;
		case "vote":
			server.sendOne(server.getClientID(name), CS + "4/vote and /votekick are unimplemented.");
			break;
			if (cmd.length != 2) {
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
			break;
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
	}*/

}
