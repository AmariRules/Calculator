package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;

public abstract class Operator {
    private static final String  DELIMITERS= "+-*^/";

    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractOperator() );


   static HashMap<String, Operator> Operators = new HashMap<String, Operator>();

    static {
//    HashMap Operators = new HashMap();

        Operators.put("+", new AddOperator() );
        Operators.put("-", new SubtractOperator());
        Operators.put("*", new MultiplyOperator());
        Operators.put("/", new DivideOperator());
        Operators.put("^", new PowerOperator());
        Operators.put("(", new LeftParentOperator());
        Operators.put(")", new RightParentOperator());
        }


    public abstract int priority();
    public abstract Operand execute(Operand op1, Operand op2 );

    //returns the Operator stored within the HashMap
    public static Operator getOperator(String s) {
        return Operators.get(s);
    }

    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     */
    // tried a bunch of times but this has to be static in my opinion.
    public static boolean check(String token) {
        return token.equals("+") || token.equals("-")|| token.equals("/") || token.equals("*") || token.equals("^") || token.equals("(") || token.equals(")");
//        try{
//            boolean Good = false;
//            if()
//                Good = false;//| token=="123456789";
//           System.out.println(Good);
//            return Good;
//        }catch (Exce) {
//           return false;
        }

    }








