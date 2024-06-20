import java.util.Scanner;

public class Parser {
    String expression;

    public Parser() {

        String inputLine = new Scanner(System.in).nextLine();
        this.expression = "+" + inputLine.replaceAll(" ", "");


    }

    public String[] parseToNums() {
        return expression.split("[\\+\\-\\*\\/]");
    }

    public String[] parseToOps() {
        return expression.split("[1234567890]+");
    }

}
