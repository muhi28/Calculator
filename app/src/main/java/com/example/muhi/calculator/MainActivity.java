package com.example.muhi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tx1,tx2, result;
    Button bt;
    EditText input, output;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text des ersten Labels mit Hilfe der Resourcen aus strings.xml setzen.
         tx1 = (TextView)this.findViewById(R.id.text1_in);
         tx1.setText(R.string.dividend);

         tx2 = (TextView)this.findViewById(R.id.text2_in);
        tx2.setText(R.string.divisor);


        //Button
        bt = (Button)this.findViewById(R.id.button_id);
        bt.setText(R.string.buttonname);


        //Zahlen eingaben:

        input = (EditText)this.findViewById(R.id.editText_input);
        output = (EditText)this.findViewById(R.id.editText_output);






    }
}
