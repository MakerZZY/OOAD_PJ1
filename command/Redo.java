package command;

import component.Display;

public class Redo implements Command {
    public static final String identifier = "r";
    public Redo(){}

    @Override
    public void doCommand(Display d) {

    }

    @Override
    public void print()  {
        System.out.println(identifier);
    }
}
