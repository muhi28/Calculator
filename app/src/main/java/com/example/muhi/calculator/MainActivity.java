package com.example.muhi.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView out, exception, exception2;
    private EditText input, input2;
    private double result, dividend, divisor;

    Calculations calc = new Calculations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ergebnis && Fehlermeldung
        out = (TextView)this.findViewById(R.id.result_id);
        exception = (TextView)this.findViewById(R.id.textView_id);
        exception2 = (TextView) this.findViewById(R.id.textView2_id);

        //Buttons
        Button bt1 = (Button) this.findViewById(R.id.button_id);
        final Button bt2 = (Button)this.findViewById(R.id.ok_id);
        final Button bt3 = (Button)this.findViewById(R.id.clear_id);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Übernehmen der eingegebenen Zahlen:
                input = (EditText) findViewById(R.id.input1_id);
                input2 = (EditText)findViewById(R.id.input2_id);

                dividend = Double.parseDouble(input.getText().toString());
                divisor = Double.parseDouble(input2.getText().toString());


                if(divisor == 0){

                    exception.setText(R.string.dbzero);
                    exception2.setText(R.string.notnull);

                    exception.setVisibility(View.VISIBLE);
                    exception2.setVisibility(View.VISIBLE);


                    bt2.setVisibility(View.VISIBLE);

                    bt2.setOnClickListener(new View.OnClickListener(){


                        @Override
                        public void onClick(View view) {

                            bt2.setVisibility(View.INVISIBLE);
                            exception.setVisibility(View.INVISIBLE);
                            exception2.setVisibility(View.INVISIBLE);

                            clearInput();
                        }
                    });
                }
               else
                {
                    result = calc.divison(dividend,divisor);
                    out.setText(Double.toString(result));

                    exception.setVisibility(View.INVISIBLE);
                    out.setVisibility(View.VISIBLE);

                    bt3.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            clear();

                        }
                    });

                }



            }
        });
    }

    private void clear(){

        out.setText(null);
        input.setText(null);
        input2.setText(null);
    }

    public void clearInput(){

        input2.setText(null);
    }
   /* public double calculate(double dividend, double divisor)  {

        if(divisor == 0)throw new ArithmeticException();

        result = dividend/divisor;

        return result;
    }*/
}
