package edu.csc413.calculator.evaluator;

import java.util.HashMap;
import java.util.Stack;
/**
 * Operand class used to represent an operand
 * in a valid mathmetical expression.
 */
public class Operand {

  /**
  * construct operand from string token.
  */
  Stack<Integer> HoldOperand = new Stack<>();


  public Operand( String token ) {
    int result = Integer.parseInt(token);
    HoldOperand.push(result);
  }
  /**
   * construct operand from integer
   */
  public Operand( int value ) {
    HoldOperand.push(value);
  }
  /**
   * return value of operand
   */
  public int getValue() {
  if (HoldOperand.peek()==null)
    return 0;
  else
    return HoldOperand.pop();
  }
  /**
   * Check to see if given token is a valid
   * operand.
   */
  public static boolean check( String token ) {
    String regExpr = "\\+ - * / \\^";

    try{
      int result = Integer.parseInt(token);
        return true;
    }catch (NumberFormatException ex) {
      return false;
//      boolean check =false;
//
//      for (int i = 1; i<regExpr.length() && check == false; i++) {
//        if (token.matches(regExpr) == true) {
//          check = true;
//        }

      }
     // return check;
    }


  }

