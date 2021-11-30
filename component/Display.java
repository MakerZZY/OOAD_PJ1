package component;

import command.*;

import java.util.ArrayList;

public class Display {
    private String text;

    private String initiate;
    private int newHistoryPtr;
    private ArrayList<History> histories;

    public Display(String text) {
        this.initiate = text;
        this.text = text;
        histories = new ArrayList<History>();
        newHistoryPtr = 0;
    }

    public void updateHistory(Command c) {
        for (int i = histories.size() - 1; i >= newHistoryPtr; i--)
            histories.remove(i);
        histories.add(new History(c, text));
        newHistoryPtr += 1;
    }

    public void showText() {
        System.out.println("[CURRENT TEXT]$ " + text);
    }

    public void appendTail(String append) {
        text += append;
    }

    public void appendHead(String append) {
        text = append + text;
    }

    public void deleteTail(int num) {
        if (num > text.length()) {
            System.out.println("DELETE NUM BIGGER THAN TEXT LENGTH!");
            return;
        } else
            text = text.substring(0, text.length() - num);
    }

    public void deleteHead(int num) {
        if (num > text.length()) {
            System.out.println("DELETE NUM BIGGER THAN TEXT LENGTH!");
            return;
        } else
            text = text.substring(num, text.length());
    }

    public void showHistory(int num) {
        if (num > histories.size()) {
            System.out.println("LIST NUM BIGGER THAN HISTORY COMMAND LENGTH!");
            return;
        }
        for (int i = 0; i < num; i++)
            histories.get(i).getCommand().print();
    }

    public void undo() {
        if (newHistoryPtr == 0) {
            System.out.println("CANNOT UNDO ANYMORE!");
            return;
        }
        if (newHistoryPtr == 1) {
            text = initiate;
            newHistoryPtr--;
            return;
        }
        text = histories.get(--newHistoryPtr - 1).getAfterExecuted();
    }

    public void redo() {
        if (newHistoryPtr == histories.size()) {
            System.out.println("CANNOT REDO!");
            return;
        }
        text = histories.get(newHistoryPtr++).getAfterExecuted();
    }
}
