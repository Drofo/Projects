public class Process {
    String[] operators;
    String[] nums;

    public Process(String[] operators, String[] nums) {
        this.operators = operators;
        this.nums = nums;
    }

    public Double process() {
        Double sum = 0.0;
        sum = process(operators[0], nums[1], sum);
        sum = process(operators[1], nums[2], sum);

        if (nums.length > 3) {
            sum = process(operators[2], nums[3], sum);
        }
        return sum;

    }

    // передача оператора и числа
    private Double process(String op, String num, Double sum) {
        if (op.equals("+")) {
            double summa = sum + Double.parseDouble(num);
            return summa;
        }
        if (op.equals("-")) {
            double summa = sum - Double.parseDouble(num);
            return summa;
        }
        if (op.equals("*")) {
            double summa = sum * Double.parseDouble(num);
            return summa;
        }
        if (op.equals("/")) {
            double summa = sum / Double.parseDouble(num);
            return summa;
        }
        return -1.0;
    }


}
