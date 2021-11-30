package command;

import component.Display;

public class ShowText implements Command {
    public static final String identifier = "s";

    public ShowText() {
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void doCommand(Display d){
        d.showText();
    }

    @Override
    public void print() {
        System.out.println(identifier);
    }
}