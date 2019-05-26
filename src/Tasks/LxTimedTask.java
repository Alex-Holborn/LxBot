package Tasks;

import Exceptions.TaskFinishedException;
import main.Gui;
import main.Main;

public abstract class LxTimedTask extends LxTask {

    private long runtimeMS; //The amount of milliseconds to run task for
    private long startTime;

    LxTimedTask(Main m, Gui g, long runtimeMins){
        super(m, g);
        runtimeMS = runtimeMins * 60000;
        startTime = System.currentTimeMillis();
    }

    public void runTask() throws TaskFinishedException {
        if(!getMain().myPlayer().isAnimating()) {
            if (runtimeMS <= System.currentTimeMillis() - startTime) {
                throw new TaskFinishedException(getMain(), this, "Timed Task has completed successfully");
            }
        }
    }
}
