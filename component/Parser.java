package component;

import command.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
    private HashMap<String, MacroCommand> macros;

    public Parser() {
        this.macros = new HashMap<>();
    }

    public void putMacros(String name, MacroCommand macro) {
        macros.put(name, macro);
    }

    public Command parseLine(String line) {
        Command c = null;
        Scanner scan = new Scanner(line);
        if (!scan.hasNext())
            return null;
        String command = scan.next();
        switch (command) {
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
            case SetLang.identifier: {
                if (scan.hasNext())
                    c = new SetLang(scan.next());
                break;
            }
            case SetMode.identifier: {
                if (scan.hasNext())
                    c = new SetMode(scan.next());
                break;
            }
            case Spell.identifier: {
                if (!scan.hasNext())
                    c = new Spell();
                break;
            }
            case DefineMacro.identifier: {
                int num = scan.hasNextInt() ? scan.nextInt() : 0;
                String name = scan.hasNext() ? scan.next() : "";
                if (num == 0 || name.equals(""))
                    break;
                c = new DefineMacro(num, name);
            }
            default: {
                if (command.charAt(0) == '$')
                    c = macros.get(command.substring(1));
            }
        }
        return c;
    }
}
