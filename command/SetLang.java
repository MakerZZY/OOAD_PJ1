package command;

import component.Display;

public class SetLang implements Command {
    private String lang;
    public static final String identifier = "lang";

    public SetLang(String s) {
        lang = s;
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void doCommand(Display d) {
        d.setLang(lang);
    }

    @Override
    public void print() {
        System.out.println(identifier + " " + lang);
    }
}
