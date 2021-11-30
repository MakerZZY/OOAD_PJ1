package command;

import component.Display;

public class DefineMacro implements Command {
    private int num;
    private String name;
    public static final String identifier = "m";

    public DefineMacro(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void doCommand(Display d) {
        d.defineMacro(num, name);
    }

    @Override
    public void print() {
        assert false;
        // should not reach here
    }
}
