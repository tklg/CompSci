package task;

public interface Priority {
	
	static final int MED_PRI = 50;
	static final int MIN_PRI = 0;
	static final int MAX_PRI = 100;

	public void setPriority(int pri);
	public int getPriority();
	
}
