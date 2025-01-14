package command;

import component.Display;

public class ListHistory implements Command {
    private int num;
    public static final String identifier = "l";

    public ListHistory(int num) {
        this.num = num;
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void doCommand(Display d) {
        d.showHistory(num);
    }

    @Override
    public void print() {
        assert false;
        // should not reach here
    }
}
