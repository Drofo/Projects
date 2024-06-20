public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        String[] nums = parser.parseToNums();
        String[] operators = parser.parseToOps();

        Validator validator = new Validator(nums);
        validator.validate();

        Process process = new Process(operators, nums);

        System.out.println("Итог: " + process.process());

    }

}
