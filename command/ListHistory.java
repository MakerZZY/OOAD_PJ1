package command;

import component.Display;

public class ListHistory implements Command {
    private int num;

    public ListHistory(int n) {
        num = n;
    }

    public static final String identifier = "l";

    @Override
    public void doCommand(Display d) {
        d.showHistory(num);
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + num);
    }
}
