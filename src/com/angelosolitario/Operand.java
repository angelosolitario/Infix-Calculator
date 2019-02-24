package com.angelosolitario;

/**
 * Operand class used to represent an operand
 * in a valid mathmetical expression.
 */
public class Operand {

    private int makeOperand;

    /**
     * construct operand from string token.
     */
    public Operand(String token) {
        makeOperand = Integer.parseInt(token);

    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        makeOperand = value;
    }

    /**
     * return value of opernad
     */
    public int getValue() {
        return makeOperand;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try {
            Integer.parseInt(token);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

