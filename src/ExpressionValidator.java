import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionValidator {
    /**
     * Проводит валидацию выражения
     * @param expression
     * @return Возвращает не пустой список строк, если есть ошибки синтаксиса
     */
    private static List<AbstractMap.SimpleEntry<Pattern, String>> validations = List.of(
            new AbstractMap.SimpleEntry(Pattern.compile("[1-9][1-9]+"), "Числа должны быть от 0 до 10!"),
            new AbstractMap.SimpleEntry(
                    Pattern.compile("[\\+\\-\\*\\/]*\\d{1,2}[\\+\\-\\*\\/]+\\d{1,2}[\\+\\-\\*\\/]+\\d{1,2}[\\+\\-\\*\\/]+\\d{1,2}.*"),
                    "Не должно быть больше 3 операций в входном выражении"
            )
    );
    public static List<String> validate(String expression) {
        List<String> errors = new ArrayList<>();
        for(int i = 0; i<validations.size(); i++) {
            boolean searchResult = validations.get(i).getKey().matcher(expression).find();
            if (searchResult) {
                errors.add(validations.get(i).getValue());
            }
        }
        return errors;
    }
}
