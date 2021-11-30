import command.Command;
import component.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        if (args.length == 0) {
            text = "";
        } else if (args[0].equals("-t")) {
            text = args[1];
        } else {
            System.out.println("Usage: [-t \"init text\"]");
            return;
        }
        Display display = new Display(text);

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String commandLine = scan.nextLine();
            if (commandLine.equals("exit"))
                break;
            Command c = display.getParser().parseLine(commandLine);
            if (c == null) {
                System.out.println("INVALID COMMAND: " + commandLine);
                continue;
            }
            c.doCommand(display);
            if (c.modified())
                display.updateHistory(c);
        }
        scan.close();
    }
}
