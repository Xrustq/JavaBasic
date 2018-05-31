package Calculator;

import java.util.*;

public class ConvertInfixToRPN {

   public static String[] convertInfixToRPN(String expression) {

       String[] parseToInfix = expression.trim().split("\\s+");

        Map<String, Integer> prededence = new HashMap<>();
        prededence.put("/", 5);
        prededence.put("*", 5);
        prededence.put("+", 4);
        prededence.put("-", 4);
        prededence.put("(", 0);

        Deque<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();

        for (String token : parseToInfix) {
            if ("(".equals(token)) {
                S.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(S.peek())) {
                    Q.add(S.pop());
                }
                S.pop();
                continue;
            }
            // an operator
            if (prededence.containsKey(token)) {
                while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }

            if (isNumber(token)) {
                Q.add(token);
                continue;
            }

            throw new IllegalArgumentException("Неверное выражение.");
        }
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }

        System.out.println("Выражение в обратной польской записи : \n" +
                            Arrays.toString(Q.toArray(new String[Q.size()])));

        return Q.toArray(new String[Q.size()]);
    }

    static boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
