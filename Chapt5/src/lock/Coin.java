package lock;

import villa7.*;
import java.util.*;

public class Coin implements Lockable {
	
	private Print p = new Print();
	private Scanner sc = new Scanner(System.in);

	private final int HEADS = 0;
	private int face;
	
	public Coin() {
		flip();
	}
	public Coin(String unencodedKey) {
		generateKey(unencodedKey);
		//flip();
	}
	
	public void flip() {
		if (!locked) {
			face = (int) (Math.random() * 2);
		} else {
			p.nl ("Coin in locked.");
		}
	}
	public boolean isHeads() {
		if (!locked) {
			return (face == HEADS);
		} else {
			return false;
		}
	}
	public String toString() {
		if (!locked) {
			String fName;
			if (face == HEADS) {
				fName = "Heads";
			} else {
				fName = "Tails";
			}
			return fName;
		} else {
			p.nl("Coin is locked.");
			return "LOCKED";
		}
	}
	
	private boolean locked = false;
	private String key = "somerandonSHA2key";
	private final String salt = "RANDOM_SALT_OF_WORDS";
	
	public void generateKey(String unencodedKey) {
		setKey(SHA2.hash(unencodedKey, salt));
	}
	public void setKey(String encodedKey) {
		key = encodedKey;
		p.nl("Set key to " + key);
		p.nl("Coin has been locked.");
		locked = true;
	}
	public void lock() {
		p.nl("Locked.");
		locked = true;
	}
	public boolean unlock(String unencodedKeyPassed) {
		if (SHA2.hash(unencodedKeyPassed, salt).equals(key)) {
			p.nl("Unlocked!");
			locked = false;
			return true;
		} else {
			p.nl("Incorrect key.");
			return false;
		}
	}
	public boolean locked() {
		return locked;
	}
}
