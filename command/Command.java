package command;

import component.Display;

public interface Command {
    boolean modified();
    void doCommand(Display d);
    void print();
}
