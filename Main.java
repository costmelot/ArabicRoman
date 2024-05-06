import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        System.out.println(" ");

        String result = "";

        String[] args = input.split(" ");
        int spaceCount = input.split(" ").length - 1;
        if (spaceCount < 2) throw new Exception("т.к. строка не является математической операцией");
        if (spaceCount > 2)
            throw new Exception("/т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        String op1 = args[0];
        String operator = args[1];
        String op2 = args[2];
        int tempResult = 0;
        int op1Int = 0;
        int op2Int = 0;

        if (Validator.validateInput(op1, op2, operator) == "roman") {
            op1Int = Converter.romanToInt(op1);
            op2Int = Converter.romanToInt(op2);
            tempResult = makeTheCalculation(operator, op1Int, op2Int);
            result = Converter.IntegerToRomanNumeral(tempResult);
        } else {
            op1Int = Integer.valueOf(op1);
            op2Int = Integer.valueOf(op2);
            tempResult = makeTheCalculation(operator, op1Int, op2Int);
            result = Integer.toString(tempResult);
        }
        return result;
    }

    private static int makeTheCalculation(String operator, int op1Int, int op2Int) {
        int temp = switch (operator) {
            case "+" -> op1Int + op2Int;
            case "-" -> op1Int - op2Int;
            case "/" -> op1Int / op2Int;
            case "*" -> op1Int * op2Int;
            default -> 0;
        };
        return temp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите первый операнд, оператор, второй операнд через пробел в одну строку:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
        scanner.close();

    }
}