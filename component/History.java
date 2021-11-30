package component;

import command.Command;

public class History {
    private Command command;
    private String beforeExecuted;

    public History(Command c, String s) {
        command = c;
        beforeExecuted = s;
    }

    public Command getCommand() {
        return command;
    }

    public String getBeforeExecuted() {
        return beforeExecuted;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setBeforeExecuted(String beforeExecuted) {
        this.beforeExecuted = beforeExecuted;
    }
}
