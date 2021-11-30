package component;

import command.*;

import java.util.Scanner;

public class Parser {
    public static Command parseLine(String line) {
        Command c = null;
        Scanner scan = new Scanner(line);

        switch (scan.next()) {
            case AppendHead.identifier: {
                int first = line.indexOf("\"") + 1;
                int last = line.lastIndexOf("\"");
                c = new AppendHead(line.substring(first, last));
                break;
            }
            case AppendTail.identifier: {
                int first = line.indexOf("\"") + 1;
                int last = line.lastIndexOf("\"");
                c = new AppendTail(line.substring(first, last));
                break;
            }
            case DeleteHead.identifier: {
                c = new DeleteHead(scan.nextInt());
                break;
            }
            case DeleteTail.identifier: {
                c = new DeleteTail(scan.nextInt());
                break;
            }
            case ShowText.identifier: {
                c = new ShowText();
                break;
            }
            case ListHistory.identifier: {
                c = new ListHistory(scan.nextInt());
                break;
            }
        }

        return c;
    }
}
