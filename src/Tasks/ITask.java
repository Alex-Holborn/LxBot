package Tasks;

import Exceptions.CannotStartException;
import Exceptions.TaskFinishedException;

interface ITask {

    void runTask() throws TaskFinishedException;

    void init() throws CannotStartException;

}
