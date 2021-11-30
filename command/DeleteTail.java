package command;

import component.Display;

public class DeleteTail implements Command {
    private int num;
    public static final String identifier = "D";

    public DeleteTail(int num) {
        this.num = num;
    }

    @Override
    public boolean modified() {
        return true;
    }

    @Override
    public void doCommand(Display d) {
        d.deleteTail(num);
    }

    @Override
    public void print() {
        System.out.print(identifier + " " + num);
    }
}
