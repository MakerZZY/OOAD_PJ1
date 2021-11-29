public class ListChangeCommand implements Command{
    int num;
    public static final String identifier = "l";
    public ListChangeCommand(int num) {
        this.num = num;
    }
    @Override
    public void doCommand(Display d){
        d.deleteTail(num);
        d.addCommandHistory(this);
        d.addChangeHistory(this);
        d.addTextHistory();
        d.showText();
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + num);
    }
}
