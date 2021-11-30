package command;

import component.Display;

public class DeleteHead implements Command{
    private int num;
    public static final String identifier = "d";
    public DeleteHead(int num) {
        this.num = num;
    }

    @Override
    public void doCommand(Display d){
        d.deleteHead(num);
        d.updateHistory(this);
        d.showText();
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + num);
    }
}
