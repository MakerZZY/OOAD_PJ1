package command;

import component.Display;

public class ShowText implements Command {
    public ShowText(){}
    public static final String identifier = "s";

    @Override
    public void doCommand(Display d){
        d.showText();
    }

    @Override
    public void print() {
        System.out.println(identifier);
    }
}