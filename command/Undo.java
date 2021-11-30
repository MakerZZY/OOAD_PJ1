package command;

import component.Display;

public class Undo implements Command {
    public static final String identifier = "u";
    public Undo(){}

    @Override
    public void doCommand(Display d) {
        d.undo();
    }

    @Override
    public void print()  {
        System.out.println(identifier);
    }
}
