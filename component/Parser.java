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
                String sub = line.substring(first, last);
                if (first != 0 && first < last && !sub.contains("\""))
                    c = new AppendHead(sub);
                break;
            }
            case AppendTail.identifier: {
                int first = line.indexOf("\"") + 1;
                int last = line.lastIndexOf("\"");
                String sub = line.substring(first, last);
                if (first != 0 && first < last && !sub.contains("\""))
                    c = new AppendTail(sub);
                break;
            }
            case DeleteHead.identifier: {
                if (scan.hasNextInt())
                    c = new DeleteHead(scan.nextInt());
                break;
            }
            case DeleteTail.identifier: {
                if (scan.hasNextInt())
                    c = new DeleteTail(scan.nextInt());
                break;
            }
            case ShowText.identifier: {
                if (!scan.hasNext())
                    c = new ShowText();
                break;
            }
            case ListHistory.identifier: {
                if (scan.hasNextInt())
                    c = new ListHistory(scan.nextInt());
                break;
            }
            case Undo.identifier: {
                if (!scan.hasNext())
                    c = new Undo();
                break;
            }
            case Redo.identifier: {
                if (!scan.hasNext())
                    c = new Redo();
                break;
            }
        }

        return c;
    }
}
