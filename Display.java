import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private String text;
    private ArrayList<Command> commandHistory;
    private ArrayList<Command> changeCommandHistory;
    private ArrayList<String> textHistory;

    public Display(String text) {
        this.text = text;
        commandHistory = new ArrayList<Command>();
        changeCommandHistory = new ArrayList<Command>();
        textHistory = new ArrayList<String>();
    }

    public void addCommandHistory(Command c) {
        commandHistory.add(c);
    }

    public void addChangeHistory(Command c) {
        changeCommandHistory.add(c);
    }

    public void addTextHistory(){
        textHistory.add(text);
    }


    public void showText() {
        System.out.println(text);
    }
    public void appendTail(String append) {
        text += append;
    }
    public void appendHead(String append) {
        text = append + text;
    }
    public void deleteTail(int num) {
        if (num > text.length())
            System.out.println("DELETE NUM BIGGER THAN TEXT LENGTH!");
        else
            text = text.substring(0, text.length() - num);
    }
    public void deleteHead(int num) {
        if (num > text.length())
            System.out.println("DELETE NUM BIGGER THAN TEXT LENGTH!");
        else
            text = text.substring(num, text.length());
    }
    public void showHistory(int num) {
        if (num > commandHistory.size())
            System.out.println("LIST NUM BIGGER THAN HISTORY COMMAND LENGTH!");
        for (int i = 0; i < num; i++)
            commandHistory.get(i).print();
    }
    public static void main(String[] args) {
        String text = (args.length > 0 && args[0] != "-t") ? args[1] : "";
        Display display = new Display(text);
        display.addTextHistory();

        Scanner scan = new Scanner(System.in);

        // 判断是否还有输入
        while (scan.hasNextLine()) {
            String commandLine = scan.nextLine();
            Command c = Parser.parseLine(commandLine);
            c.doCommand(display);
        }
        scan.close();
    }
}

