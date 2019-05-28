package Tasks;

import Exceptions.CannotStartException;
import Exceptions.TaskFinishedException;
import main.Gui;
import main.Main;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.utility.ConditionalSleep;

public class BlastFurnace extends LxTask {

    private final Area mainArea = new Area(new Position(1935, 4956, 0), new Position(1957, 4974, 0));
    private final Area lobby = new Area(new Position(2931,10195,0), new Position(2932,10197,0));
    private final int entryStairsID = 9084;

    

    public BlastFurnace(Main m, Gui g){
        super(m, g);
    }

    @Override
    public void init() throws CannotStartException{
        if(!mainArea.contains(getMain().myPosition()) && !lobby.contains(getMain().myPosition())){
            throw new CannotStartException(getMain(), this, "Not in one of the starting areas, stopping...");
        }
        if(lobby.contains(getMain().myPosition())){
            if(!enterMainArea()){
                throw new CannotStartException(getMain(), this, "Cannot enter Blast Furnace, stopping");
            }
        }
    }

    private boolean enterMainArea(){
        getMain().getObjects().closest(9084).interact();
        new ConditionalSleep(10000){
            @Override
            public boolean condition() throws InterruptedException {
                return mainArea.contains(getMain().myPosition());
            }
        }.sleep();
        return mainArea.contains(getMain().myPosition());
    }

    @Override
    public void runTask() throws TaskFinishedException {

    }
}
