package Calculator;

import java.util.Stack;

public class CalculatePRN {
    public static int evalRPN(String[] exp) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i].matches("-?[\\d]+")) {
                stack.push(Integer.parseInt(exp[i]));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                String operator = exp[i];
                if (operator.equals("+")) result = op1 + op2;
                else if (operator.equals("-")) result = op1 - op2;
                else if (operator.equals("*")) result = op1 * op2;
                else if (operator.equals("/")) result = op1 / op2;
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void print(String expression) {

        System.out.println("\n" + expression + " = " + evalRPN(ConvertInfixToRPN.convertInfixToRPN(expression)));
    }
}
