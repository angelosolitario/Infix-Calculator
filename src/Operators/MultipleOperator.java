package Operators;

import com.angelosolitario.Operand;

public class MultipleOperator extends Operator {
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand operand  = new Operand(op1.getValue()*op2.getValue());
        return operand;
    }
}
