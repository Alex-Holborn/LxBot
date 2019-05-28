package Exceptions;

import Tasks.LxTask;
import main.Main;

public class LxCeption extends Exception {

    private LxTask thrownTask;
    private String message;

    LxCeption(Main m, LxTask t, String mssg){
        super();
        m.log(mssg);
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
