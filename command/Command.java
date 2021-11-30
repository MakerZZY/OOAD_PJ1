package command;

import component.Display;

public interface Command {
    void doCommand(Display d);
    void print();
}
