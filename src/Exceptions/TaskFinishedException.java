package Exceptions;

import Tasks.LxTask;
import main.Main;

public class TaskFinishedException extends LxCeption {


    public TaskFinishedException(Main m, LxTask t, String mssg) {
        super(m, t, mssg);
    }
}
