class Validator {

    private static boolean isRoman(String inputStr) {
        return inputStr.matches("^I$|^II$|^III$|^IV$|^V$|^VI$|^VII$|^VIII$|^IX$|^X$");
    }

    private static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String validateInput(String input1, String input2, String operator) throws Exception {
        String result = "";
        if (!operator.matches("[-+*/]{1}")) {
            throw new RuntimeException("Оператор должен быть одним из следующего списка: [+,-,*,/]");
        }

        if (isRoman(input1) ^ isRoman(input2)) {
            throw new RuntimeException("т.к. используются одновременно разные системы счисления");
        }
        if (!isRoman(input1) && !isRoman(input2) && (!isStringInt(input1) || !isStringInt(input1))) {
            throw new RuntimeException("т.к. в римской системе нет отрицательных чисел, калькулятор работает только с целыми числами");
        }
        int op1 = 0;
        int op2 = 0;

        if (isRoman(input1)) {
            Converter romanOp = new Converter();
            op1 = romanOp.romanToInt(input1);
            op2 = romanOp.romanToInt(input2);
        } else {
            op1 = Integer.parseInt(String.valueOf(input1));
            op2 = Integer.parseInt(String.valueOf(input2));
        }

        if (((op1 < 1) || (op1 > 10)) || ((op2 < 1) || (op2 > 10))) {
            throw new RuntimeException("Числа должны быть от 1 до 10");
        }

        if (isRoman(input1)) {
            result = "roman";
        } else {
            result = "decimal";
        }

        return result;
    }
}