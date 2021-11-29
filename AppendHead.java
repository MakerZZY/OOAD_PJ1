public class AppendHead implements Command {
    String append;
    public static final String identifier = "a";
    public AppendHead(String s) {
        append = s;
    }

    @Override
    public void doCommand(Display d){
        d.appendHead(append);
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
