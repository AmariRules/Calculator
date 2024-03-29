package edu.csc413.calculator.evaluator;



import edu.csc413.calculator.operators.Operator;
import sun.invoke.empty.Empty;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/()";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators


        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                //  System.out.println(token);
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        //System.out.print(!Operator.check(token));
                        // System.out.println(token);
                        throw new RuntimeException("*****invalid token******");
                    } else if (token.equals(")")) {
                        while (!operatorStack.peek().equals(Operator.getOperator("("))) {
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(operatorStack.pop().execute(op1, op2));
                        }
                        operatorStack.pop();
                    } else {


                        // TODO Operator is abstract - these two lines will need to be fixed:
                        // The Operator class should contain an instance of a HashMap,
                        // and values will be instances of the Operators.  See Operator class
                        // skeleton for an example.


                        //  while(!operatorStack.isEmpty()){
                        Operator newOperator = Operator.getOperator(token);
                        if (!token.equals("(")) {
                            while (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) { //&& ) {

//                        newOperator = operatorStack.peek();
                                // note that when we eval the expression 1 - 2 we will
                                // push the 1 then the 2 and then do the subtraction operation
                                // This means that the first number to be popped is the
                                // second operand, not the first operand - see the following code
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();

                                operandStack.push(oldOpr.execute(op1, op2));
                                //     operandStack.push(newOperator.execute(op1, op2));

                                //System.out.print(oldOpr.execute(op1,op2));
                                // System.out.println(operandStack.pop().getValue());
                            }
                        }
                            operatorStack.push(newOperator);


                        }

                }
            }
        }





            // Control gets here when we've picked up all of the tokens; you must add
            // code to complete the evaluation - consider how the code given here
            // will evaluate the expression 1+2*3
            // When we have no more tokens to scan, the operand stack will contain 1 2
            // and the operator stack will have + * with 2 and * on the top;
            // In order to complete the evaluation we must empty the stacks (except
            // the init operator on the operator stack); that is, we should keep
            // evaluating the operator stack until it only contains the init operator;
            // Suggestion: create a method that takes an operator as argument and
            // then executes the while loop.
            Operand op1;
            Operand op2;
            Operand Result = new Operand(0);

//        System.out.println("Past empty safadftack");

        while(!operandStack.isEmpty() && !operatorStack.isEmpty()) {
            op1 = operandStack.pop();
            op2 = operandStack.pop();
//                if (!operandStack.isEmpty()) {

            //System.out.println("Past empty stack");
            Operator temp = operatorStack.pop();

            //if(temp.equals(operatorStack.lastElement())){
            //if (temp.priority() <=operatorStack.peek().priority()) {
            // if(temp.equals(operatorStack.elementAt(1))){
            Result = temp.execute(op2, op1);
            operandStack.push(Result);
        //    temp = operatorStack.pop();

        }
                //}


            return Result.getValue();
        }
    }

