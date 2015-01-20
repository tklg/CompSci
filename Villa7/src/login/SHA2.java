package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA2 {

	public static String hash(String p) {
	    try {
	        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
	        String salt = "somerandomsalt";
	        String passWithSalt = p + salt;
	        byte[] passBytes = passWithSalt.getBytes();
	        byte[] passHash = sha256.digest(passBytes);             
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< passHash.length ;i++) {
	            sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));         
	        }
	        String generatedPass = sb.toString();
	        return generatedPass;
	    } catch (NoSuchAlgorithmException e) { 
	    	e.printStackTrace(); 
	    }       
	    return null;
	}
	public static String hash(String p, String s) {
	    try {
	        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
	        String salt = s;
	        String passWithSalt = p + salt;
	        byte[] passBytes = passWithSalt.getBytes();
	        byte[] passHash = sha256.digest(passBytes);             
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< passHash.length ;i++) {
	            sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));         
	        }
	        String generatedPass = sb.toString();
	        return generatedPass;
	    } catch (NoSuchAlgorithmException e) { 
	    	e.printStackTrace(); 
	    }       
	    return null;
	}
}
