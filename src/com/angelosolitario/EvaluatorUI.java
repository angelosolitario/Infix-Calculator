package com.angelosolitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
    Evaluator calculatorTest = new Evaluator();
    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
            "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
            "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    String expr = "";

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        //changed the size because it was too small on my laptop
        setSize(1500, 1500);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // complete this function
    public void actionPerformed(ActionEvent arg0) {
        // You need to fill in this fuction

        String input = txField.getText();

        if (arg0.getSource() == buttons[18]) {
            //this will erase all text
            txField.setText("");
            expr = "";
        } else if (arg0.getSource() == buttons[19]) {
            //deletes one character
            if (!txField.getText().equals(""))
                txField.setText(txField.getText().substring(0, txField.getText().length() - 1));

        } else if (arg0.getSource() == buttons[14]) {
            // this is the equal sign
            txField.setText("" + Integer.toString(calculatorTest.eval(expr)));
        } else {
            for (int i = 0; i < buttons.length; i++) {
                if (arg0.getSource() == buttons[i]) {
                    txField.setText(input + bText[i]);
                    expr = expr + bText[i];
                }
            }
        }
    }
}

