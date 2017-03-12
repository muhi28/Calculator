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

        // Eingabe der unten stehenden Werte
        onView(withId(R.id.input1_id))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("5"), closeSoftKeyboard());


        //Ausführen der Division
        onView(withId(R.id.button_id)).perform(click());


        //prüfen, ob die Division das richtige Ergebnis liefert
        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(10,5)))));


        //löschen der eingegebenen Werte und dem Ergebnis
        onView(withId(R.id.clear_id)).perform(click());

        // prüfen ob Werte auch wirklic gelöscht wurden

        onView(withId(R.id.input1_id)).check(matches(withText("")));
        onView(withId(R.id.input2_id)).check(matches(withText("")));


    }

    @Test
    public void TestDivisionDouble(){


        // Eingabe der unten stehenden Werte
        onView(withId(R.id.input1_id))
                .perform(typeText("185.5"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("2.5"), closeSoftKeyboard());


        //Ausführen der Division
        onView(withId(R.id.button_id)).perform(click());


        // Prüfen ob die Divison das richtige Ergebnis liefert.
        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(185.5,2.5)))));



        // löschen der vorhandenen Werte
        onView(withId(R.id.clear_id)).perform(click());

        //prüfen ob Werte wirklich gelöscht wurden
        onView(withId(R.id.input1_id)).check(matches(withText("")));
        onView(withId(R.id.input2_id)).check(matches(withText("")));


        // Eingabe der unten stehenden Werte
        onView(withId(R.id.input1_id))
                .perform(typeText("847.5"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("1.2225"), closeSoftKeyboard());


        // Ausführen der Division
        onView(withId(R.id.button_id)).perform(click());


        // Prüfen ob die Divison das richtige Ergebnis liefert.
        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(847.5,1.2225)))));


        // löschen der eingegebenen Werte
        onView(withId(R.id.clear_id)).perform(click());


        // prüfen ob die Werte wirklich gelöscht wurden
        onView(withId(R.id.input1_id)).check(matches(withText("")));
        onView(withId(R.id.input2_id)).check(matches(withText("")));
    }

    @Test
    public void TestDivisionNegativeNumbers(){


        // Eingabe der unten stehenden Werte

        onView(withId(R.id.input1_id))
                .perform(typeText("-105"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("-45"), closeSoftKeyboard());


        // löschen der eingegebenen Werte
        onView(withId(R.id.button_id)).perform(click());

        // Prüfen ob die Divison das richtige Ergebnis liefert.
        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(-105,-45)))));

        // löschen der eingegebenen Werte
        onView(withId(R.id.clear_id)).perform(click());


        // prüfen ob die Werte wirklich gelöscht wurden
        onView(withId(R.id.input1_id)).check(matches(withText("")));
        onView(withId(R.id.input2_id)).check(matches(withText("")));

    }
    @Test
    public void TestClearandDivisionwithNegDouble(){

        // Eingabe der unten stehenden Werte

        onView(withId(R.id.input1_id))
                .perform(typeText("-1742.856"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("-8.712"), closeSoftKeyboard());


        // löschen der eingegebenen Werte
        onView(withId(R.id.clear_id)).perform(click());


        // Eingabe der unten stehenden Werte
        onView(withId(R.id.input1_id))
                .perform(typeText("-6428.4"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("-8.47"), closeSoftKeyboard());

        // Ausführen der Berechnung
        onView(withId(R.id.button_id)).perform(click());

        // Prüfen ob die Divison das richtige Ergebnis liefert.
        onView(withId(R.id.result_id)).check(matches(withText(Double.toString(calc.divison(-6428.4,-8.47)))));


        // löschen der eingegebenen Daten
        onView(withId(R.id.clear_id)).perform(click());


        // prüfen ob die Werte wirklich gelöscht wurden
        onView(withId(R.id.input1_id)).check(matches(withText("")));
        onView(withId(R.id.input2_id)).check(matches(withText("")));

    }


    @Test
    public void testDivisionbyzero(){


        // Eingabe der unten stehenden Werte
        onView(withId(R.id.input1_id))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.input2_id))
                .perform(typeText("0"), closeSoftKeyboard());


        // Ausführen der Division
        onView(withId(R.id.button_id)).perform(click());

        // prüfen ob die Textfelder den richten Text anzeigen
        onView(withId(R.id.textView_id)).check(matches(withText("DIVIDE BY 0 !!!")));
        onView(withId(R.id.textView2_id)).check(matches(withText("ZAHL ungleich 0 eingeben.")));



        // durch drücken des OK-Buttons werden die Textfelder auf INVISIBLE gestellt
        onView(withId(R.id.ok_id)).perform(click());

        // prüfen ob der Wert nach drücken von OK auch wirklich entfernt wurde
        onView(withId(R.id.input2_id)).check(matches(withText("")));

    }


}
