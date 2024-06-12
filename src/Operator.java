public interface Operator {
    double calc(double first, double second);
}

class PlusOperator implements Operator {
    @Override
    public double calc(double first, double second) {
        return first + second;
    }
}

class MinusOperator implements Operator {
    @Override
    public double calc(double first, double second) {
        return first - second;
    }
}

class DevideOperator implements Operator {
    @Override
    public double calc(double first, double second) {
        return first / second;
    }
}

class MultiplyOperator implements Operator {
    @Override
    public double calc(double first, double second) {
        return first * second;
    }
}


