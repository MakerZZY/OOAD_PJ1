public class AppendTail implements Command {
    String append;
    public static final String identifier = "A";
    public AppendTail(String s) {
        append = s;
    }
    @Override
    public void doCommand(Display d){
        d.appendTail(append);
        d.addCommandHistory(this);
        d.addChangeHistory(this);
        d.addTextHistory();
        d.showText();
    }

    @Override
    public void print() {
        System.out.println(identifier + " \"" + append + "\"");
    }
}
