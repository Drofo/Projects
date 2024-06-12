import java.util.AbstractMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    private final Pattern EXPRESSION_REGEX = Pattern.compile("[\\*\\/\\+\\-]");
    private String expression;

    public ExpressionParser() {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if (!str.startsWith("[\\+\\-]")) {
            str = "+" + str;
        }
        this.expression = str.replaceAll(" ", "");
        this.validate();
    }

    private boolean validate() {
        List<String> errors = ExpressionValidator.validate(this.expression);
        if (!errors.isEmpty()) {
            String errorString = "[";
            for(int i = 0; i < errors.size(); i++) {
                errorString += errors.get(i) + ",\n";
            }
            errorString += "]";
            throw new IllegalArgumentException("Имеются ошибки валидации: \n" + errorString);
        }
        return true;
    }

    /***
     * Функция отрезающая от выражения один оператор и число, изменяет исходную строку
     * @return возвращает один оператор и число
     */
    public AbstractMap.SimpleEntry<String, String> next() {
        Matcher match = EXPRESSION_REGEX.matcher(expression);
        match.find();
        int firstIndex = match.start();
        boolean isMatch = match.find();
        int secondIndex = -1;
        if (isMatch){
            secondIndex=match.start();
        }
        String number, op;
        if (secondIndex!= -1) {
            number = expression.substring(firstIndex+1, secondIndex);
            op = expression.substring(firstIndex, firstIndex+1);
            this.expression = expression.substring(secondIndex,expression.length());
        } else {
            number = expression.substring(firstIndex+1, expression.length());
            op = expression.substring(firstIndex, firstIndex+1);
            this.expression = "";
        }
        return new AbstractMap.SimpleEntry<String, String>(op, number);
    }

    public boolean expressionIsNotEmpty() {
        return !this.expression.isEmpty();
    }
}
