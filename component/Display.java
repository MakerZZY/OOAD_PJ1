package component;

import command.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Display {
    private String text;
    private String check;
    private String initiate;
    private int newHistoryPtr;
    private ArrayList<History> histories;
    private Set<String> words;
    private String path;
    private Parser parser;

    public Display(String text) {
        this.initiate = text;
        this.text = text;
        histories = new ArrayList<History>();
        newHistoryPtr = 0;
        parser = new Parser();
    }

    public Parser getParser() {
        return parser;
    }

    private void initWords() {
        words = new HashSet<>();
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            while ((s = br.readLine()) != null) {
                words.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        int historySize = histories.size();
        if (num > historySize) {
            System.out.println("MACRO LENGTH TO BIG!");
            return;
        }
        for (int i = historySize - num; i < historySize; i++) {
            histories.get(i).getCommand().print();
            System.out.println("");
        }
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

    public void defineMacro(int num, String name) {
        int historySize = histories.size();
        if (num > historySize) {
            System.out.println("MACRO LENGTH TO BIG!");
            return;
        }
        ArrayList<Command> list = new ArrayList<>();
        for (int i = historySize - num; i < historySize; i++)
            list.add(histories.get(i).getCommand());
        parser.putMacros(name, new MacroCommand(name, list));
    }

    public void setLang(String lang) {
        if ("eng" == lang)
            path = "eng.txt";
        else if ("fra" == lang)
            path = "fra.txt";
        else
            System.out.println("LANGUAGE NOT SUPPORTED!");
    }

    public void setMode(String mode) {
        check = text.replaceAll(",", "");
        check = check.replaceAll("\\.", "");
        if ("xml" == mode) {
            check = check.replaceAll("<.*?>", "");
        } else if ("txt" != mode)
            System.out.println("MODE NOT SUPPORTED!");
    }


    public void spell() {
        if (path == null) {
            System.out.println("YOU MUST SET LANGUAGE FIRST!");
            return;
        } else if (check == null) {
            System.out.println("YOU MUST SET MODE FIRST!");
            return;
        }
        initWords();
        String[] split = check.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            if (!words.contains(split[i]))
                System.out.println(split[i]);
        }
    }
}
