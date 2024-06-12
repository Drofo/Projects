import java.util.AbstractMap;

public class Processor {
    private final ExpressionParser parser;
    public Processor() {
        this.parser = new ExpressionParser();
    }

    public double process() {
        double sum = 0;
        while (parser.expressionIsNotEmpty()) {
            AbstractMap.SimpleEntry<String, String> opAndNum = parser.next();
            sum = OperatorFabric.build(opAndNum.getKey()).calc(
                    Double.parseDouble(opAndNum.getValue()),
                    sum
            );
        }
        return sum;
    }
}
