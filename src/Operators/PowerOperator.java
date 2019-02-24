package Operators;

import com.angelosolitario.Operand;

public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int temp = 1;
        for(int i =0; i<op2.getValue(); i++){
            temp = temp*op1.getValue();
        }

        Operand result = new Operand(temp);

        return result;
    }
}
