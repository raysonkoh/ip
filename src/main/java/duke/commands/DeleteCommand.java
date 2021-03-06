package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.exception.DukeException;
import duke.tasks.Task;

/**
 * Represents the Command to delete existing Tasks from taskList.
 */
public class DeleteCommand implements Command {

    private final int taskNum;

    /**
     * Initializes DeleteCommand.
     *
     * @param taskNum The number of the task in the taskList to be deleted.
     */
    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Deletes the task at the specified taskNum in the taskList.
     *
     * @param storage The storage object.
     * @param tasks   The taskList.
     * @return The response indicating task has been deleted from taskList.
     * @throws DukeException If taskNum index out of bounds.
     */
    @Override
    public String execute(Storage storage, TaskList tasks) throws DukeException {
        try {
            Task delTask = tasks.delete(taskNum);
            return "OK! I have deleted the following task for your list:\n" + delTask.toString() + "\n" + tasks
                    .getListStatus();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(e.getMessage());
        }
    }
}
