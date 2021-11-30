package command;

import component.Display;

public class Spell implements Command {
    public static final String identifier = "spell";

    public Spell() { }

    @Override
    public void doCommand(Display d) {
        d.spell();
    }

    @Override
    public void print() {
        System.out.println(identifier);
    }
}
