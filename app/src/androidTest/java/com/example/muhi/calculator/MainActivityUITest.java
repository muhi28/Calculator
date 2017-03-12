package com.example.muhi.calculator;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 *Created by Muhi on 11.03.2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    private Calculations calc;

    @Before
    public void setUpCalc(){

        calc = new Calculations();
    }

     @After
     public void removeCalc(){

         calc = null;
     }


    @Rule
    public  ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDivision(){

        onView(withId(R.id.input1_id))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());

        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(10,5)))));

        onView(withId(R.id.clear_id)).perform(click());
    }

    @Test
    public void TestDivisionDouble(){

        onView(withId(R.id.input1_id))
                .perform(typeText("185.5"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("2.5"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());

        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(185.5,2.5)))));



        // löschen der vorhandenen Werte

        onView(withId(R.id.clear_id)).perform(click());



        onView(withId(R.id.input1_id))
                .perform(typeText("847.5"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("1.2225"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());

        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(847.5,1.2225)))));

        onView(withId(R.id.clear_id)).perform(click());
    }

    @Test
    public void TestDivisionNegativeNumbers(){



        onView(withId(R.id.input1_id))
                .perform(typeText("-105"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("-45"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());


        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(-105,-45)))));

        onView(withId(R.id.clear_id)).perform(click());

    }
    @Test
    public void TestDivisionwithNegDouble(){

        onView(withId(R.id.input1_id))
                .perform(typeText("-1742.856"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("-8.712"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());

        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(-1742.856,-8.712)))));

        onView(withId(R.id.clear_id)).perform(click());

    }


    @Test
    public void testDivisionbyzero(){

        onView(withId(R.id.input1_id))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("0"), closeSoftKeyboard());

        onView(withId(R.id.button_id)).perform(click());


        onView(withId(R.id.textView_id)).check(matches(withText("DIVIDE BY 0 !!!")));
        onView(withId(R.id.textView2_id)).check(matches(withText("ZAHL ungleich 0 eingeben.")));

        onView(withId(R.id.ok_id)).perform(click());

    }


}
