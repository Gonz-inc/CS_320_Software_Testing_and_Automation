package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Task_Services.Task;

class TaskTest{
	
	public Task taskOne;
	
	@BeforeEach 
	public void setUp(){
		String taskID = "T201565100";
		String taskName = "Creating a new task.";
		String taskDef = "New Task will be created for new assingment roles.";
	
		taskOne = new Task(taskID, taskName, taskDef);
	}
	@Test
	public void testTask(){
		assertFalse(taskOne.getTaskID().equals("T2015651"));
		assertFalse(taskOne.getTaskName().equals("Remodel"));
		assertFalse(taskOne.getTaskDef().equals("remodle the interrior space for client."));
		assertTrue(taskOne.getTaskID().equals("T201565100"));
		assertTrue(taskOne.getTaskName().equals("Creating a new task."));
		assertTrue(taskOne.getTaskDef().equals("New Task will be created for new assingment roles."));
	}
	
	/*
	 * I have added new variables to test the out of bounds within the task test.
	 * NOTE: these three test will verify the task ID, Name, and Definition throw exceptions because they
	 * are larger then the specified size.
	 */
	
	@Test 
	void taskIDtoBigTest() {
		//This ID size is to large greater then 10 charaters.
		String toLongID = "T201565122215";
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task(toLongID,taskOne.getTaskName(),taskOne.getTaskDef());
		});
	}
	
	@Test 
	void taskNameToLong() {
		
		//Size of this task name is to large more then 20 charaters.
		String longName = "Creating a new task for a new client";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskOne.getTaskID(), longName, taskOne.getTaskDef());
			});
	}
	
	@Test
	void taskDefToLong() {
		//Large def greater then 50 charters 
		String longDef = "New Task will be created for new assingment roles with a new client.";
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskOne.getTaskID(), taskOne.getTaskName(), longDef);
		});
	}
	
	
	//***********************TESTS the size of the task ID, Name, and Definition when they are lower then the specifed size.
	@Test 
	void smallTaskIDSizeTest() {
		//Size of ID is less then 10
		String shortID = "T120";
		
		Task shortTask = new Task(shortID, taskOne.getTaskName(), taskOne.getTaskDef());
		assertTrue(shortTask.getTaskID().length() < 10);
		
		//Verifies that no exceptions were thrown. 
		Assertions.assertDoesNotThrow(() -> {
			new Task(shortID, taskOne.getTaskName(), taskOne.getTaskDef());
		});
		
	}
	
	@Test
	void smallTaskNameSizeTest() {
		
		//The task name size is less then 20 charaters.
		String shortName = "N/A";
		
		Task nameTask = new Task(taskOne.getTaskID(),shortName,taskOne.getTaskDef());
		assertTrue(nameTask.getTaskName().length() < 20);
		
		Assertions.assertDoesNotThrow(()-> {
			new Task(taskOne.getTaskID(),shortName ,taskOne.getTaskDef());
		});
		
	}
	
	
	
	@Test
	void smallTaskDefSizeTest() {
		
		//The size of this string is less then 50 charaters.
		String shortDef = "None";
		
		Task defTask = new Task(taskOne.getTaskID(), taskOne.getTaskName(), shortDef);
		assertTrue(defTask.getTaskDef().length() < 50);

		Assertions.assertDoesNotThrow(()-> {
			new Task(taskOne.getTaskID(), taskOne.getTaskName(),shortDef);
		});
		
	}
	
	
	//*************************Test the String size to make sure that Task ID, Name, and Definition are at max size.
	@Test
	
	void validTaskIDSizeTest() {
		//String size is 10 characters Long
		String normalID = "T201556210";
		
		Task task = new Task(normalID, taskOne.getTaskName(), taskOne.getTaskDef());
		//Test to make user it is equal to the ten charters.
		assertEquals(10, task.getTaskID().length());
		
		//Shows that no exceptions were thrown.
		Assertions.assertDoesNotThrow(()-> task);
	}
	
	@Test
	void validTaskNameSizeTest() {
		//String size is 20 characters.
		String normalTaskName = "Creating a new task.";
		
		Task task = new Task(taskOne.getTaskID(), normalTaskName, taskOne.getTaskDef());
		//Validates that it is equal to 20 characters.
		assertEquals(20, task.getTaskName().length());
		
		//Shows that no exceptions were thrown.
		Assertions.assertDoesNotThrow(() -> task);
	}
	
	@Test
	void validTaskDefSizeTest() {
		
		//String is 50 characters long/
		String normalTaskDef = "New Task will be created for new assingment roles.";
		
		Task task = new Task(taskOne.getTaskID(), taskOne.getTaskName(), normalTaskDef);
		
		//Validates that it is equal to 50 characters 
		assertEquals(50, task.getTaskDef().length());
		
		//Show that now exceptions were thrown.
		Assertions.assertDoesNotThrow(() -> task);
	}
	
	
	//****************************************NUll TESTS*********************
	
	@Test 
	void taskIDNullTest() {
		
		//Null String
		String nullID = null;		
		
		//Validates that an exceptions is thrown.
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task(nullID,taskOne.getTaskName(), taskOne.getTaskDef());
		});

	}
	
	@Test 
	void taskNameNullTest() {
		
		//Null String 
		String nullName = null;
				
		//Shows that an exceptions is thrown.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskOne.getTaskID(), nullName, taskOne.getTaskDef());
			});
	}
	
	@Test 
	void taskDefNullTest() {

		//null String
		String nullDef = null;
		
		//Shows that an exceptions is thrown.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskOne.getTaskID(), taskOne.getTaskName(), nullDef);
		});
		
	}
	
	/*
	 * testing the setters methods.
	 */
	
	@Test
	public void testSetter() {
		Task taskTwo = new Task("T2015473", "Demo Appliances", "Clients will be touring Demo Showroom");
		taskTwo.setTaskDef("Demo the ShowRoom.");
		taskTwo.setTaskName("Show Room Demo.");
		assertTrue(taskTwo.getTaskID().equals("T2015473"));
		assertTrue(taskTwo.getTaskName().equals("Show Room Demo."));
		assertTrue(taskTwo.getTaskDef().equals("Demo the ShowRoom."));
	}
}