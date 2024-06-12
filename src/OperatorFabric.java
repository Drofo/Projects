public class OperatorFabric {
    public static Operator build(String op) {
        switch(op){
            case "+": return new PlusOperator();
            case "-": return new MinusOperator();
            case "*": return new MultiplyOperator();
            case "/": return new DevideOperator();
        }
       throw new IllegalArgumentException("Данный оператор не поддерживается: {}" + op);
    }
}
