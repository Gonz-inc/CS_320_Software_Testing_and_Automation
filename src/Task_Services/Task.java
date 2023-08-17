package Task_Services;

public class Task{

    /* The attributes are as followed the first is protected string for the unique task ID.
    * Second the task name that is also a string.
    * Third the task definition which is abbreviated as def.
    */
    private String taskID;
    private String taskName;
    private String taskDef;
    
    public Task(String taskID, String taskName, String taskDef){
      // verification methods calls.
      verfTaskID(taskID);
      verfTaskName(taskName);
      verfDef(taskDef);

      this.taskID = taskID;    
      this.taskName = taskName;
      this.taskDef = taskDef;

     }
   /**************Getters******************/
    public String getTaskID(){
         return taskID;
    }
     
    public String getTaskName(){
      return taskName;
    }
   
    public String getTaskDef(){
      return taskDef;
    }

    /**************Setters for task service******************/
    /* These methods are for the setting task variable attributes for
     * the update methods in taskService class.
     */
    public void setTaskName(String taskName) {
    	this.taskName = taskName;
    }
    
    public void setTaskDef(String taskDef) {
    	this.taskDef = taskDef;
    }
    
    /**************Verification******************/

    public String verfTaskID(String idIn){
      if ( idIn == null || idIn.length() > 10 ) {
        throw new IllegalArgumentException("Invalid ID");
      }
      else { 
    	  return idIn; 
      }
    }
   
    public String verfTaskName(String taskIn) {
        if (taskIn == null || taskIn.length() > 20){          
        	throw new IllegalArgumentException("Input Error");
        }
        else { 
        	return taskIn; 
        }
     }
    
    public String verfDef(String defIn){
        if (defIn == null || defIn.length() > 50){
        	throw new IllegalArgumentException("Invalid Defenition");
        }
        else { 
        	return defIn; 
        	}
      }
     
    }