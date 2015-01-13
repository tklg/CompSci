package task;
import Interface.Complexity;

public class Task2 implements Priority, Complexity{

	public int pri = 0,
			   cx = 0;
	private String desc = "UNDEFINED";
	
	public Task2(){};
	public Task2(String desc) {
		this.desc = desc;
	}
	public Task2(String desc, int pri, int cx) {
		this.desc = desc;
		this.pri = pri;
		this.cx = cx;
	}
	public int getPriority() {
		return pri;
	}
	public void setPriority(int pri) {
		this.pri = pri;
	}
	public int getComplexity() {
		return cx;
	}
	public void setComplexity(int cx) {
		this.cx = cx;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public String toString() {
		return ("TASK '" + desc + "'\tPRIORITY " + pri + "\tCOMPLEXITY " + cx);
	}
}
