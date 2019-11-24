package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.AddOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    private int result = 0;
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

        setTitle("Amari's Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
    }

    public void actionPerformed(ActionEvent arg0) {
//    if (arg0.equals("+"))

        //  if (arg0.equals(buttons[0])) {


//        buttons[i].

        if (arg0.getSource() == buttons[0]) {
            jButton7ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[1]) {
            jButton8ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[2]) {
            jButton9ActionPerformed(arg0);

        }
        if (arg0.getSource() == buttons[3]) {
            plusjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[4]) {
            jButton4ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[5]) {
            jButton5ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[6]) {
            jButton6ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[7]) {
            minusjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[8]) {
            jButton1ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[9]) {
            jButton2ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[10]) {
            jButton3ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[11]) {
            MultiplyjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[12]) {
            jButton0ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[13]) {
            ExpjButton3ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[14]) {
            EqualsjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[15]) {
            DivideActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[16]) {
            LPjButton3ActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[17]) {
            RPjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[18]) {
            ClearjButtonActionPerformed(arg0);
        }
        if (arg0.getSource() == buttons[19]) {
            ClearErrorButtonActionPerformed(arg0);
        }

        //   actionPerformed(java.awt.event.ActionEvent arg0);


    }

    private void ClearErrorButtonActionPerformed(ActionEvent arg0) {
        txField.setText("");

    }

    private void ClearjButtonActionPerformed(ActionEvent arg0) {
        txField.setText("");

    }

    private void RPjButtonActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[17]);

    }

    private void LPjButton3ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[16]);
    }

    private void DivideActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[9]);
    }

    private void EqualsjButtonActionPerformed(ActionEvent arg0) {
        Evaluator op = new Evaluator();
        txField.setText(String.valueOf(op.eval(txField.getText())));
    }

    private void ExpjButton3ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[13]);
    }

    private void jButton0ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[12]);
    }

    private void MultiplyjButtonActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[11]);
    }

    private void jButton3ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[10]);
    }

    private void jButton5ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[5]);
    }

    private void jButton4ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[4]);
    }

    private void jButton1ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[8]);
    }

    private void jButton6ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[6]);
    }

    private void plusjButtonActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[3]);
    }

    private void minusjButtonActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[7]);
    }

    private void jButton2ActionPerformed(ActionEvent arg0) {
        txField.setText(txField.getText() + bText[9]);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent arg0) {//GEN-FIRST:event_jButton1ActionPerformed
        txField.setText(txField.getText() + bText[0]);
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent arg0) {//GEN-FIRST:event_jButton1ActionPerformed
        txField.setText(txField.getText() + bText[1]);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent arg0) {//GEN-FIRST:event_jButton1ActionPerformed
        txField.setText(txField.getText() + bText[2]);
    }
}