public class Parser {
    static Command parseLine(String line) {
        Command c = null;
        if (line.length() == 1 || line.charAt(1) == ' ') {
            switch (line.substring(0, 1)) {
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
                    int num = Integer.valueOf(line.substring(2));
                    c = new DeleteHead(num);
                    break;
                }
                case DeleteTail.identifier: {
                    int num = Integer.valueOf(line.substring(2));
                    c = new DeleteTail(num);
                    break;
                }
                case ShowText.identifier: {
                    c = new ShowText();
                    break;
                }
            }
        }
        return c;
    }
}
