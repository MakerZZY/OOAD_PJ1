package command;

import component.Display;

public class SetMode implements Command {
    private String mode;
    public static final String identifier = "content";

    public SetMode(String s) {
        mode = s;
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void doCommand(Display d) {
        d.setMode(mode);
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + mode);
    }
}
