package Exceptions;

import Tasks.LxTask;
import main.Main;

public class CannotStartException extends LxCeption {

    public CannotStartException(Main m, LxTask t, String mssg){
        super(m,t,mssg);
    }

}
