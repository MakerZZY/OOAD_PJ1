package command;

import component.Display;

public class AppendTail implements Command {
    private String append;
    public static final String identifier = "A";

    public AppendTail(String s) {
        append = s;
    }

    @Override
    public void doCommand(Display d) {
        d.appendTail(append);
        d.updateHistory(this);
    }

    @Override
    public void print() {
        System.out.println(identifier + " \"" + append + "\"");
    }
}
