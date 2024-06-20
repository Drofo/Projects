public class Validator {
    String[] numbers;

    public Validator(String[] numbers) {
        this.numbers = numbers;
    }


    public boolean validate() {
        if (numbers.length > 4 || numbers.length < 3) {
            throw new IllegalArgumentException("Ты переборщил/недоборщил немного");
        }
        if ((Double.parseDouble(numbers[1]) > 10 || Double.parseDouble(numbers[2]) > 10) ||
                (numbers.length > 3 && Double.parseDouble(numbers[3]) > 10)) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
        return true;
    }
}
