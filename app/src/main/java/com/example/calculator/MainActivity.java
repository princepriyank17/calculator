package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private ImageButton back;
    private Button ac;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button percentage;
    private Button equal;
    private Button dot;
    private TextView result;
    private TextView input;
    private final char Add = '+';
    private final char Sub = '-';
    private final char Mul = '*';
    private final char Div = '/';
    private final char Per = '%';
    private double num1 = Double.NaN;
    private double num2 = Double.NaN;
    private char Action;
    private final char Equal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+".");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Add;
                result.setText(String.valueOf(num1)+"+");
                input.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Sub;
                result.setText(String.valueOf(num1)+"-");
                input.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Mul;
                result.setText(String.valueOf(num1)+"*");
                input.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Div;
                result.setText(String.valueOf(num1)+"/");
                input.setText(null);
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Per;
                result.setText(String.valueOf(num1)+"%");
                input.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action = Equal;
                result.setText(String.valueOf(num1));
                input.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length()>0){
                    CharSequence name = input.getText().toString();
                    input.setText(name.subSequence(0,name.length()-1));
                }
                else
                {
                    num1= Double.NaN;
                    num2 = Double.NaN;
                    input.setText(null);
                    result.setText(null);
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= Double.NaN;
                num2 = Double.NaN;
                input.setText(null);
                result.setText(null);
            }
        });

    }

    private void setUpUIViews(){
        zero = (Button) findViewById(R.id.btn0);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        dot = (Button) findViewById(R.id.btndot);
        add = (Button) findViewById(R.id.btnAdd);
        subtract = (Button) findViewById(R.id.btnSub);
        multiply = (Button) findViewById(R.id.btnMul);
        divide = (Button) findViewById(R.id.btnDiv);
        ac = (Button) findViewById(R.id.btnAC);
        percentage = (Button) findViewById(R.id.btnPer);
        equal = (Button) findViewById(R.id.btnResult);
        back = (ImageButton) findViewById(R.id.back);
        input = (TextView) findViewById(R.id.btnIn);
        result = (TextView) findViewById(R.id.btnOut);



    }
    private void compute(){
        if(!Double.isNaN(num1)){
            num2 = Double.parseDouble(input.getText().toString());
            switch(Action){
                case Add:
                    num1=num1+num2;
                    break;
                case Sub:
                    num1=num1-num2;
                    break;
                case Mul:
                    num1=num1*num2;
                    break;
                case Div:
                    num1=num1/num2;
                    break;
                case Per:
                    num1=num1*100/num2;
                    break;
                case Equal:
                    break;
            }
        }
        else{
            num1 = Double.parseDouble(input.getText().toString());
        }
    }
}
