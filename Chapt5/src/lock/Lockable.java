package lock;

public interface Lockable {

	public void setKey(String key);
	public void lock();
	public boolean unlock(String unencodedKeyPassed);
	public boolean locked();
	
}
