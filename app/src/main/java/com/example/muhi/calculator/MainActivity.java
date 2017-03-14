package com.example.muhi.calculator;

import android.app.Activity;
import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


    private TextView out, error2;
    private EditText input, input2;
    private Button ok,clear;
    private double dividend, divisor;
    private boolean empty;




    Calculations calc = new Calculations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set the OutputTextField and the Error Message TextFields
        out = (TextView)this.findViewById(R.id.result_id);
        error2 = (TextView) this.findViewById(R.id.textView2_id);

        //set the Buttons
         Button calculation = (Button) this.findViewById(R.id.button_id);
          ok = (Button)this.findViewById(R.id.ok_id);
         clear = (Button)this.findViewById(R.id.clear_id);

        //get the Input
        input = (EditText) findViewById(R.id.input1_id);
        input2 = (EditText)findViewById(R.id.input2_id);



        //set the Listener of Divide-Button
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check, if the input is empty
                if(checkInputEmpty())
                {
                    //set the Ok-Button to VISIBLE
                    ok.setVisibility(View.VISIBLE);
                    out.setText(R.string.error);
                    out.setVisibility(View.VISIBLE);


                    return;
                }

                // checks whether the Input has a incorrect format
                else if(checkInputFormat())
                {

                    //if its true, then set the Error-Messages
                    error2.setText(R.string.incorrectInput);
                    error2.setVisibility(View.VISIBLE);

                    out.setText(R.string.error);
                    ok.setVisibility(View.VISIBLE);

                    return;
                }

                // set the Values for the Calculation
                dividend = Double.parseDouble(input.getText().toString());
                divisor = Double.parseDouble(input2.getText().toString());


                // check whether the divisor equals ZERO
                 if(checkDivisionbyZero(divisor))
                {

                    input2.setError("Zahl ungleich 0 eingeben");
                    out.setText(R.string.error);
                    out.setVisibility(View.VISIBLE);

                }

                // if the Input has a correct format and the divisor is not ZERO then start the Calculation
                else
                {
                    error2.setVisibility(View.INVISIBLE);
                    ok.setVisibility(View.INVISIBLE);
                    // execute the calculation
                    Calculate();
                }

            }
        });

        // set the onClickListener for the CLEAR-Button
        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                clear();

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkWrongInput();

                error2.setVisibility(View.INVISIBLE);
                out.setVisibility(View.INVISIBLE);
                ok.setVisibility(View.INVISIBLE);
            }
        });

    }


    // clears the output and the input
    private void clear(){

        out.setText(null);
        input.setText(null);
        input2.setText(null);
    }


    // check whether the Input-Format is incorrect
    public boolean checkInputFormat(){

        boolean check = false;

        if(input.getText().toString().equals(".")|| input.getText().toString().equals("-")
                || input.getText().toString().equals("+")){

            check = true;

        }
        else if (input2.getText().toString().equals(".") || input2.getText().toString().equals("-")
                || input2.getText().toString().equals("+")){

            check = true;
        }

        return check;
    }


    public void checkWrongInput(){

        if(input.getText().toString().equals(".") || input.getText().toString().equals("-")
                || input.getText().toString().equals("+"))
        {

            input.setText(null);

        }
         if(input2.getText().toString().equals(".") || input2.getText().toString().equals("-")
                 || input2.getText().toString().equals("+"))
         {

            input2.setText(null);
        }
    }

    // check whether the divisor is zero
    public boolean checkDivisionbyZero(double divisor){

        boolean error = false;

        if(divisor == 0){

            error = true;
        }
            return error;
    }

    // check whether the inputs are empty
    public boolean checkInputEmpty(){

         empty = false;

        // sets the error message if the dividend is empty
        if(input.getText().toString().isEmpty()){

            empty = true;

            error2.setText(R.string.dividenderror);
            error2.setVisibility(View.VISIBLE);

            input.setError("Bitte Dividend eingeben.");
        }
        //sets the error message if the divisor is empty
         if( input2.getText().toString().isEmpty()){

            empty = true;

             error2.setText(R.string.divisorerror);
             error2.setVisibility(View.VISIBLE);

           input2.setError("Bitte Divisor eingeben.");

        }
         if(input.getText().toString().isEmpty() && input2.getText().toString().isEmpty()) {

            empty = true;

            error2.setText(R.string.nothing);
            error2.setVisibility(View.VISIBLE);

        }

        return empty;
    }

    // start the Calculation
    public void Calculate(){

        double result = calc.divison(dividend,divisor);
        double round = 0;

        round = Math.round(result*Math.pow(10d,9))/ Math.pow(10d,9);
       // result = Math.round(result * 100000000)/100000000;

        out.setText(Double.toString(round));

        error2.setVisibility(View.INVISIBLE);
        out.setVisibility(View.VISIBLE);

    }

}
