package Exceptions;

import Tasks.LxTask;
import main.Main;

public class TaskFinishedException extends Exception {

    private LxTask thrownTask;
    private String message;

    public TaskFinishedException(Main m, LxTask t, String mssg){
        super();
        thrownTask = t;
        message = mssg;
    }

    public LxTask getThrownTask(){
        return thrownTask;
    }

    public String getMessage(){
        return message;
    }
}
