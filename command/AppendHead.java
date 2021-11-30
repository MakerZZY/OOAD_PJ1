package command;

import component.Display;

public class AppendHead implements Command {
    private String append;
    public static final String identifier = "a";

    public AppendHead(String s) {
        append = s;
    }

    @Override
    public void doCommand(Display d) {
        d.appendHead(append);
        d.updateHistory(this);
    }

    @Override
    public void print() {
        System.out.println(identifier + " \"" + append + "\"");
    }
}
