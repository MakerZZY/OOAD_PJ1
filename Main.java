import command.*;
import component.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String text = (args.length > 0 && args[0] != "-t") ? args[1] : "";
        Display display = new Display(text);

        Scanner scan = new Scanner(System.in);

//        while (scan.hasNextLine()) {
//            String commandLine = scan.nextLine();
//            if (commandLine.equals("exit"))
//                break;
//            Command c = Parser.parseLine(commandLine);
//            if (c == null) {
//                System.out.println("INVALID COMMAND: " + commandLine);
//                continue;
//            }
//            c.doCommand(display);
//            display.showText();
//        }


        new AppendTail("Quel est votre point de vue").doCommand(display);
        new AppendHead("What is younew r point of view, and, ").doCommand(display);
        new SetLang("fra").doCommand(display);
        new SetMode("txt").doCommand(display);
        new ShowText().doCommand(display);
        new Spell().doCommand(display);



        scan.close();


//
//        String text = "What is your point of view, and, .";
//
//        text = text.replaceAll(",", "");
//        text = text.replaceAll("\\.", "");
//        String[] split = text.split("\\s+");
//
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }





    }
}
