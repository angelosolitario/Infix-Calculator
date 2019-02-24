package com.angelosolitario;



import Operators.LeftParen;
import Operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator
{

    //Stacks to store operands and operators
    private final Stack<Operand> operandStack;
    private final Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/() ";

    public Evaluator()
    {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }


    private void PerformParenthesesOperation()
    {

        while((operatorStack.peek().priority()!=0))
        {
            Operator lastOperator = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();


            operandStack.push( lastOperator.execute( op1, op2 ));
        }

        operatorStack.pop();
    }


    public int eval( String expression )
    {
        String token;

        this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

        while ( this.tokenizer.hasMoreTokens() )
        {
            if ( !( token = this.tokenizer.nextToken() ).equals( " " ))
            {

                if (Operand.check( token ))
                {
                    operandStack.push(new Operand( token ));
                }
                else
                {
                    if(!Operator.check( token ))
                    {
                        System.out.println( "*****invalid token******" );
                        System.exit( 1 );
                    }


                    else if(")".equals(token))
                    {
                        PerformParenthesesOperation();
                    }
                    else if("(".equals(token))
                    {
                        operatorStack.push(new LeftParen());
                    }
                    else
                    {
                        Operator newOperator = Operator.getOperator(token);

                        if(!operatorStack.isEmpty())
                        {
                            while((operandStack.size()>=2) && (!operatorStack.isEmpty())  &&  (operatorStack.peek().priority() >= (newOperator.priority())))
                            {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute( op1, op2 ));
                            }
                        }
                        operatorStack.push(newOperator);
                    }
                }
            }
        }



        while(!operatorStack.isEmpty())
        {
            Operator LastOperator = operatorStack.pop();
            Operand operator1 = operandStack.pop();
            Operand operator2 = operandStack.pop();
            operandStack.push(LastOperator.execute(operator2,operator1));
        }


        return (operandStack.pop().getValue());
    }
}
