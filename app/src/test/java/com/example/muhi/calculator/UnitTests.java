package com.example.muhi.calculator;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 *Created by Muhi on 10.03.2017.
 */

public class UnitTests {

    private Calculations calc;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp(){

        calc = new Calculations();
    }

    @After
    public void setUpAfter(){

        calc = null;
    }

    @Test(expected = ArithmeticException.class)
    public void CalculateDividebyZERO()  {

        assertEquals(0,calc.divison(25,0),0);

    }
}
