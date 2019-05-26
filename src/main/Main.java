package main;

import Exceptions.TaskFinishedException;
import Tasks.LxTask;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.util.ArrayList;

@ScriptManifest(author = "Alex", info = "A WiP Project", logo = "", name = "", version = 0)
public class Main extends Script {

    private boolean hasStarted = false;

    private LxTask[] taskQueue;

    public void onStart(){
        new Gui(this);
    }

    @Override
    public int onLoop(){
        if(hasStarted){
            if(taskQueue != null && taskQueue[0] != null){
                try{
                    taskQueue[0].runTask();
                }catch(TaskFinishedException e){
                    finishCurrentTask(e);
                }
            }
        }
        return 100;
    }

    public void createTaskQueue(ArrayList<LxTask> tasks){
        taskQueue = new LxTask[tasks.size()];
        for(int i = 0; i < tasks.size(); i++){
            taskQueue[i] = tasks.get(i);
        }
    }

    private void finishCurrentTask(TaskFinishedException e){
        LxTask[] newQ = new LxTask[taskQueue.length - 1];
        System.arraycopy(taskQueue, 1, newQ,0, newQ.length);
        log(e.getThrownTask().getTaskName() + " has finished!");
        taskQueue = newQ;
    }
}
