package Tasks;

import Exceptions.TaskFinishedException;

interface ITask {

    void runTask() throws TaskFinishedException;

}
