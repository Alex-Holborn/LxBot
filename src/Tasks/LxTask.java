package Tasks;

import main.Gui;
import main.Main;

public abstract class LxTask implements ITask {

    private Main main;

    private Gui gui;

    LxTask(Main m, Gui g){
        main = m;
        gui = g;
    }

    public String getTaskName(){
        return "LxTask";
    }

    Main getMain(){
        return main;
    }
}
