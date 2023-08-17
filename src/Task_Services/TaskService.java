package Task_Services;

import java.util.ArrayList;

public class TaskService{
	
	// in-memory data structure.
	public ArrayList<Task> listOne = new ArrayList<>();
	
	
	public void addTask(String newTaskID,String newTaskName,String newTaskDef) {
		Task newTaskObj = new Task(newTaskID, newTaskName, newTaskDef);
		listOne.add(newTaskObj);
	}
	
	
	/* Note that this method was created in order for the
	 * delete and update function to work properly.
	 *
	 * I had difficulties finding how to get this test to work
	 * without failing, initially i used a for loop for every function
	 * but ended up created a search function for the in memory data Structure
	 */
	public Task findTask(String searchID) {
		int count = 0;
		while (count < listOne.size()) {
			if (listOne.get(count).getTaskID().equals(searchID)) {
				return listOne.get(count);
			}
			count++;
		}
		throw new IllegalArgumentException("ID not found");
	}
	
	
	
	public void deleteTask(String searchID) {
		listOne.remove(findTask(searchID));
	}


	public void updateTaskStuff(String searchID, String newTaskName, String newTaskDef){
		findTask(searchID).setTaskName(newTaskName);
		findTask(searchID).setTaskDef(newTaskDef);
	}
	
}

