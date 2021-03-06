package com.company;

        import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String pattern = "";

        String expression = "3%2";
        String[] out = expression.split("\\D");
        String operator =  expression.replaceAll("[0-9]","");
        System.out.println(operator);

        ArithmeticOperation operation = new ArithmeticOperation(Double.parseDouble(out[0]),Double.parseDouble(out[1]), operator.charAt(0));
        System.out.println(operation);

        OperationChain op1 = new Addition();
        OperationChain op2 = new Subtraction();
        OperationChain op3 = new Multiplication();
        OperationChain op4 = new Division();
        OperationChain op5 = new Exponentiation();
        OperationChain op6 = new Modulo();
        op6.setNextChain(new NotImplemented());
        op5.setNextChain(op6);
        op4.setNextChain(op5);
        op3.setNextChain(op4);
        op2.setNextChain(op3);
        op1.setNextChain(op2);

        System.out.println(op1.calculate(operation));
    }
}
