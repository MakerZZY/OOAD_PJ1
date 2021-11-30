package command;

import component.Display;

import java.util.ArrayList;

public class MacroCommand implements Command {
    String name;
    ArrayList<Command> commands;

    public MacroCommand(String name, ArrayList<Command> commands) {
        this.name = name;
        this.commands = commands;
    }

    @Override
    public boolean modified() {
        return true;
    }

    @Override
    public void doCommand(Display d) {
        for (Command command : commands)
            command.doCommand(d);
    }

    @Override
    public void print() {
        System.out.print("$" + name + " { ");
        for (Command command : commands) {
            command.print();
            System.out.print("; ");
        }
        System.out.print("}");
    }
}
