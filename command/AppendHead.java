package command;

import component.Display;

public class AppendHead implements Command {
    private String append;
    public static final String identifier = "a";

    public AppendHead(String append) {
        this.append = append;
    }

    @Override
    public boolean modified() {
        return true;
    }

    @Override
    public void doCommand(Display d) {
        d.appendHead(append);
    }

    @Override
    public void print() {
        System.out.print(identifier + " \"" + append + "\"");
    }
}
