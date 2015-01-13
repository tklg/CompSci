package task;
import java.util.ArrayList;

import villa7.Print;

public class TaskDriver {

	private static Print p = new Print();
	private static final int NUM_TASKS = 10;
	private static Task task[] = new Task[NUM_TASKS];
	private static ArrayList<Task> taskList = new ArrayList<Task>();
	
	public static void main(String[] args) {
		for (int i = 0; i < NUM_TASKS; i++) {
			task[i] = new Task("Task " + (i+1), (int) Math.round(Math.random() * 100));
			taskList.add(task[i]);
		}
		for (Task task : taskList) {
			p.nl(task.toString());
		}
	}
}
