
package io.github.seriousguy888.stupidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int currentOperation = 0;
    /*
        0 - None
        1 - Division
        2 - Multiplication
        3 - Subtraction
        4 - Addition
    */

    private String[] getTerms(CharSequence expression) {
        return expression.toString().split("/|\\*|-|\\+");
    }
    private String calculate(CharSequence expression) {
        String expressString = expression.toString();
        if(currentOperation == 0) {
            return expressString;
        }
        else {
            String[] terms = getTerms(expression);
            if(currentOperation == 1) {
                return Double.toString(Double.parseDouble(terms[0]) / Double.parseDouble(terms[1]));
            }
            if(currentOperation == 2) {
                return Double.toString(Double.parseDouble(terms[0]) * Double.parseDouble(terms[1]));
            }
            if(currentOperation == 3) {
                return Double.toString(Double.parseDouble(terms[0]) - Double.parseDouble(terms[1]));
            }
            if(currentOperation == 4) {
                return Double.toString(Double.parseDouble(terms[0]) + Double.parseDouble(terms[1]));
            }
            else {
                return "error";
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView equationDisplay = findViewById(R.id.equationDisplay);

        Button buttonClear = findViewById(R.id.buttonClear);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonAdd = findViewById(R.id.buttonAdd);


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText("");
            }
        });


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(equationDisplay.getText() + "9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] terms = getTerms(equationDisplay.getText());
                if(terms[terms.length - 1].contains(".")) {
                    return;
                }

                equationDisplay.setText(equationDisplay.getText() + ".");
            }
        });


        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(calculate(equationDisplay.getText()) + "/");
                currentOperation = 1;
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(calculate(equationDisplay.getText()) + "*");
                currentOperation = 2;
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(calculate(equationDisplay.getText()) + "-");
                currentOperation = 3;
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(calculate(equationDisplay.getText()) + "+");
                currentOperation = 4;
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationDisplay.setText(calculate(equationDisplay.getText()));
                currentOperation = 0;
            }
        });
    }
}