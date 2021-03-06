package duke.tasks;

import duke.exception.DukeException;

/**
 * An abstract class that represents a basic Task.
 */
public abstract class Task {

    protected final String description;
    protected final boolean isDone;

    /**
     * Initializes a Task object.
     *
     * @param description The description of the Task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    protected Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Updates this task to the information specified in updateString.
     *
     * @param updateString A string that represents the updated task.
     * @return The updated Task.
     * @throws DukeException If updateString format is wrong.
     */
    public abstract Task update(String updateString) throws DukeException;

    /**
     * Gets the raw data representation of the Task.
     *
     * @return The raw data representation of the Task.
     */
    public String getData() {
        return (isDone ? "1" : "0") + "|" + description;
    }

    /**
     * Mark the Task as done.
     *
     * @return The Task after it is marked as done.
     */
    public abstract Task markAsDone();

    /**
     * Checks whether task description contains a certain keyword.
     *
     * @param keywords The search keyword.
     * @return Boolean value indicating whether task description contains a certain keyword.
     */
    public boolean contains(String[] keywords) {
        boolean res = true;
        for (String keyword : keywords) {
            res = description.contains(keyword) && res;
        }
        return res;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + this.description;
    }

    private String getStatusIcon() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }
}
