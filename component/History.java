package component;

import command.Command;

public class History {
    private Command command;
    private String afterExecuted;

    public History(Command c, String s) {
        command = c;
        afterExecuted = s;
    }

    public Command getCommand() {
        return command;
    }

    public String getAfterExecuted() {
        return afterExecuted;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setAfterExecuted(String afterExecuted) {
        this.afterExecuted = afterExecuted;
    }
}
