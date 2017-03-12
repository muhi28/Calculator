package com.example.muhi.calculator;

/**
 *Created by Muhi on 11.03.2017.
 */

public class Calculations {

    double result;



    public double addition(double number1, double number2){

        result = number1 + number2;

        return result;
    }

    public double subtraction(double num1, double num2){

        result = num1 - num2;

        return result;
    }

    public double divison(double dividend, double divisor){

        if(divisor == 0) throw new ArithmeticException("DIVISION durch NULL !!!");

            result = dividend / divisor;

        return result;
    }

    public double multiplication(double num1, double num2){


        result = num1 * num2;
        return result;
    }



}
