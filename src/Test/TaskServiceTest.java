package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Task_Services.TaskService;

class TaskServiceTest{
	
	/* Tests the add one service by checking if 
	 * it adds new new tasks to the task list 
	 * labeled as listOne.
	 */
	@Test
	public void testAddonService() {
		TaskService servOne = new TaskService(); 
		servOne.addTask("T2015688", "NewRemodel", "New client requested qoute for a remodel.");
		assertTrue(servOne.listOne.get(0).getTaskID().equals("T2015688"));
		assertTrue(servOne.listOne.get(0).getTaskName().equals("NewRemodel"));
		assertTrue(servOne.listOne.get(0).getTaskDef().equals("New client requested qoute for a remodel."));
		servOne.addTask("T2015111", "Close Sale", "Finzilze client paperwork.");
		assertTrue(servOne.listOne.get(1).getTaskID().equals("T2015111"));
		assertTrue(servOne.listOne.get(1).getTaskName().equals("Close Sale"));
		assertTrue(servOne.listOne.get(1).getTaskDef().equals("Finzilze client paperwork."));
	}
	
	
	// Tests to see that the actual task was deleted. 
	@Test
	public void testDeletService() {
		TaskService servOne = new TaskService(); 
		servOne.addTask("T2015688", "NewRemodel", "New client requested qoute for a remodel.");
		servOne.addTask("T2015111", "Close Sale", "Finzilze client paperwork.");
		servOne.addTask("T2015000", "Demo Floor Plans", "Demo the show rooms for client.");
		servOne.deleteTask("T2015111");
		assertFalse(servOne.listOne.get(1).getTaskID().equals("T2015111"));
	}
	
	//Tests to see if an unknown id are found.
	@Test
	public void testIDNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new TaskService().deleteTask("T2015000");
		});
	}
	
	// tests the update service by adding new tasks and updating
	// one at the specified tasks to see if a task has been updated.
	@Test 
	public void testUpdateTask() {
		TaskService servOne = new TaskService(); 
		servOne.addTask("T2015688", "NewRemodel", "New client requested qoute for a remodel.");
		servOne.addTask("T2015111", "Close Sale", "Finzilze client paperwork.");
		servOne.addTask("T2015000", "Demo Floor Plans", "Demo the show rooms for client.");
		servOne.updateTaskStuff("T2015111", "Completed Sale", "Client finalizec: Date 1-1-2015");
		assertTrue(servOne.listOne.get(1).getTaskName().equals("Completed Sale"));
		assertTrue(servOne.listOne.get(1).getTaskDef().equals("Client finalizec: Date 1-1-2015"));
	}
}

