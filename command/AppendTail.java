package command;

import component.Display;

public class AppendTail implements Command {
    private String append;
    public static final String identifier = "A";

    public AppendTail(String append) {
        this.append = append;
    }

    @Override
    public boolean modified() {
        return true;
    }

    @Override
    public void doCommand(Display d) {
        d.appendTail(append);
    }

    @Override
    public void print() {
        System.out.print(identifier + " \"" + append + "\"");
    }
}
