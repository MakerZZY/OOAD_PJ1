import command.Command;
import component.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = (args.length > 0 && args[0] != "-t") ? args[1] : "";
        Display display = new Display(text);

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String commandLine = scan.nextLine();
            if (commandLine.equals("exit"))
                break;
            Command c = Parser.parseLine(commandLine);
            c.doCommand(display);
        }
        scan.close();
    }
}
