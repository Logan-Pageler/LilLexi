package gui.commands;

/**
 * Basic frame work for storing diffrent commands. They should be executable and
 * reversable
 * 
 * @author Logan Pageler
 */
public abstract class Command {

    /**
     * Executes command. Can have various sideffects
     */
    public abstract void execute();

    /**
     * reverse command. Returns to earlier state
     */
    public abstract void reverse();
}
