package command;

import component.Display;

public class DeleteTail implements Command {
    private int num;
    public static final String identifier = "D";

    public DeleteTail(int num) {
        this.num = num;
    }

    @Override
    public void doCommand(Display d) {
        d.deleteTail(num);
        d.updateHistory(this);
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + num);
    }
}
