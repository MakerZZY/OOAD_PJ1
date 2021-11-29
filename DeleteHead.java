public class DeleteHead implements Command{
    int num;
    public static final String identifier = "d";
    public DeleteHead(int num) {
        this.num = num;
    }
    @Override
    public void doCommand(Display d){
        d.deleteHead(num);
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
