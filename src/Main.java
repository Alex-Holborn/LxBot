import Tasks.Task;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Alex", info = "A WiP Project", logo = "", name = "", version = 0)
public class Main extends Script {

    private boolean hasStarted = false;

    private Task[] taskQueue;

    public void onStart(){
        new Gui(this);
    }

    @Override
    public int onLoop(){
        if(hasStarted){

        }
        return 100;
    }
}
