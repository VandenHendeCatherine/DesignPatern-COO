package src.view;

public class ReplayConversation extends AbstractConversation<Command, Command> {
    private final Command reset;

    public ReplayConversation(Command reset) {
        this.reset = reset;
    }

    @Override public void exec(Command todo) {
        todo.execute();
        undos.push(todo);
        redos.clear();
    }

    @Override public void undo() {
        Command latestCmd = undos.pop() ;
        if(latestCmd==null) return;
        redos.push(latestCmd);
        reset.execute();
        undos.forEachFifo(cmd->cmd.execute());
    }

    @Override public void redo() {
        Command latestCmd = redos.pop() ;
        if(latestCmd==null) return;
        latestCmd.execute();
        undos.push(latestCmd);
    }
}