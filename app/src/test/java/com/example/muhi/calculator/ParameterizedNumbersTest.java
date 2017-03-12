package com.example.muhi.calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

/**
 *Created by Muhi on 12.03.2017.
 */

@RunWith(Parameterized.class)
public class  ParameterizedNumbersTest {

    private Calculations calc;
    private double number1;
    private double number2;
    private double expected;


    //@Rule
   // public ExpectedException thrown = new ExpectedException.none();

    @Before
    public void initialize(){

        calc = new Calculations();
    }


    public ParameterizedNumbersTest(double number1, double number2, double expected){

        this.number1 = number1;
        this.number2 = number2;
        this.expected = expected;
    }


    // Testen von positiven, Gelitkommazahlen und negativen Zahlen

    @Parameterized.Parameters
    public static Collection Numbers(){

        return Arrays.asList(new Object[][]{

                //negative ganze Zahlen
                {-1642,-58,(-1642.0/-58.0)},
                {-42845,-82222,(-42845.0/-82222.0)},
                {-100000,-4582,(-100000.0/-4582.0)},

                //negaitve Gleitkommazahlen
                {-452.78,-68.2,(-452.78/-68.2)},
                {-145.258,-8.245,(-145.258/-8.245)},
                {-458.47,-9.376,(-458.47/-9.376)},

                //positive ganze Zahlen
                {5,5,1},
                {10,5,2},
                {15.85,5.8,(15.85/5.8)},
                {30.846,15,(30.846/15)},
                {250.5,85.8456,(250.5/85.8456)},
                {158235,8542,(158235.0/8542.0)},

                // positive Gleitkommazahlen
                {481.5,84.4,(481.5/84.4)},
                {7542.4,12.64,(7542.4/12.64)},
                {14842.1005,69.82,(14842.1005/69.82)},
                {951.7891,8.3,(951.7891/8.3)},

                // gemischte Testfälle
                {-1485,8.4521,(-1485/8.4521)},
                {84354.857,-7.85,(84354.857/-7.85)},
                {4812,-10,(4812.0/-10.0)},
                {-945.87,4,(-945.87/4)},
                {10,4785.5,(10/4785.5)},
                {-4875,80000,(-4875.0/80000.0)}

        });
    }

    @Test
    public void testNumbers(){

        System.out.println("Parameterized Numbers are: " + number1 + " and " + number2 + "." );

            assertEquals(expected, calc.divison(number1, number2), 0);

    }
}
