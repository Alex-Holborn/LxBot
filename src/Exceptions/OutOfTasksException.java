package Exceptions;

import Tasks.LxTask;
import main.Main;

public class OutOfTasksException extends LxCeption {

    public OutOfTasksException(Main m, LxTask t, String mssg){
        super(m, t, mssg);
    }

}
