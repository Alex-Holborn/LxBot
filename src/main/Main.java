package main;

import Exceptions.CannotStartException;
import Exceptions.OutOfTasksException;
import Exceptions.TaskFinishedException;
import Tasks.LxTask;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.util.ArrayList;

@ScriptManifest(author = "Alex", info = "A WiP Project", logo = "", name = "", version = 0)
public class Main extends Script {

    private boolean hasStarted = false;

    private LxTask[] taskQueue;

    private LxTask activeTask;

    public void onStart(){
        new Gui(this);
    }

    @Override
    public int onLoop(){
        if(hasStarted){
            if(taskQueue != null ){
                if(activeTask != null){
                    if(activeTask.getHasRanInit()) {
                        try {
                            activeTask.runTask();
                        } catch (TaskFinishedException e) {
                            try {
                                finishCurrentTask(e);
                                updateActiveTask();
                            } catch (OutOfTasksException o) {
                                finishBot(o);
                            }
                        }
                    } else{
                        try {
                            activeTask.init();
                            activeTask.setHasRanInit();
                        } catch(CannotStartException e){
                            try{
                                finishCurrentTask(new TaskFinishedException(this, activeTask, "Changing Tasks..."));
                            } catch(OutOfTasksException o){
                                finishBot(o);
                            }
                        }
                    }
                }
            }
        }
        return 100;
    }

    void updateActiveTask(){
        activeTask = taskQueue[0];
    }

    void createTaskQueue(ArrayList<LxTask> tasks){
        taskQueue = new LxTask[tasks.size()];
        for(int i = 0; i < tasks.size(); i++){
            taskQueue[i] = tasks.get(i);
        }
    }

    private void finishBot(OutOfTasksException o){
        log(o.getMessage());
        stop(true);
    }

    private void finishCurrentTask(TaskFinishedException e) throws OutOfTasksException{
        if(taskQueue.length <= 1){
            throw new OutOfTasksException(this, activeTask, "Out of Available Tasks...");
        }else {
            LxTask[] newQ = new LxTask[taskQueue.length - 1];
            System.arraycopy(taskQueue, 1, newQ, 0, newQ.length);
            log(e.getThrownTask().getTaskName() + " has finished!");
            taskQueue = newQ;
        }
    }
}
