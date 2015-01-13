package task;

public class Task implements Priority {

	public int pri = 0;
	private String desc = "UNDEFINED";
	
	public Task(){};
	public Task(String desc) {
		this.desc = desc;
	}
	public Task(String desc, int pri) {
		this.desc = desc;
		this.pri = pri;
	}
	public int getPriority() {
		return pri;
	}
	public void setPriority(int pri) {
		this.pri = pri;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public String toString() {
		return ("TASK '" + desc + "'\tPRIORITY " + pri);
	}
}
