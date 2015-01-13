package task;
import java.util.ArrayList;
import villa7.*;

public class TaskDriver2 {

	private static Print p = new Print();
	private static final int NUM_TASKS = 10;
	private static Task2 task[] = new Task2[NUM_TASKS];
	private static ArrayList<Task2> taskList = new ArrayList<Task2>();
	
	public static void main(String[] args) {
		for (int i = 0; i < NUM_TASKS; i++) {
			task[i] = new Task2(SHA2.hash("Task " + (i+1)), (int) Math.round(Math.random() * 100), (int) Math.round(Math.random() * 50));
			taskList.add(task[i]);
		}
		for (Task2 task : taskList) {
			p.nl(task.toString());
		}
	}
}
