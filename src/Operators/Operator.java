package Operators;


import com.angelosolitario.Operand;

import java.util.HashMap;

public abstract class Operator {

    private static HashMap operator = new HashMap();

    static {
        operator.put("+", new AddOperator());
        operator.put("-", new SubtractOperator());
        operator.put("*", new MultipleOperator());
        operator.put("/", new DivideOperator());
        operator.put("^", new PowerOperator());
        operator.put("(", new LeftParen());
        operator.put(")", new RightParen());


    }

    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);


    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     */
    public static boolean check(String token) {
        return operator.containsKey(token);
    }

    public static Operator getOperator(String key) {
        return (Operator) operator.get(key);
    }
}
