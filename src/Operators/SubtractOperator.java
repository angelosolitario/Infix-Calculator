package Operators;

import com.angelosolitario.Operand;

public class SubtractOperator extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand result = new Operand(op1.getValue()-op2.getValue());

        return result;
    }
}
