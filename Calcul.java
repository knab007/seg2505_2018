package ca.uottawa.software.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calcul extends AppCompatActivity {

    private enum Operator {none, add, sub, mul, div, eq}
    private double data01=0;
    private Operator opp = Operator.none;
    private boolean hasDot = false;
    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
    }

    public void btn00Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "0");
    }
    public void btn01Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "1");
    }
    public void btn02Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "2");
    }
    public void btn03Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "3");
    }
    public void btn04Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "4");
    }
    public void btn05Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "5");
    }
    public void btn06Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "6");
    }
    public void btn07Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "7");
    }
    public void btn08Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "8");
    }
    public void btn09Click(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + "9");
    }
    public void btnAddClick(View view) { //Sum
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        opp = Operator.add;
        data01 = Double.parseDouble(resultTextView.getText().toString());
        resultTextView.setText("");
    }
    public void btnSubClick(View view) { //Subtraction
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        opp = Operator.sub;
        data01 = Double.parseDouble(resultTextView.getText().toString());
        resultTextView.setText("");
    }
    public void btnMulClick(View view) { //Multiplication
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        opp = Operator.mul;
        data01 = Double.parseDouble(resultTextView.getText().toString());
        resultTextView.setText("");
    }
    public void btnDivClick(View view) { //Division
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        opp = Operator.div;
        data01 = Double.parseDouble(resultTextView.getText().toString());
        resultTextView.setText("");
    }
    public void btnClearClick(View view) { //Clear/Reset
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        opp = Operator.none;
        resultTextView.setText("");
        data01 = 0;
        hasDot = false;
    }
    public void btnDotClick(View view) { //Fraction (dot)
        if (hasDot) return; //We only add a fraction marker if we don't have one already
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        resultTextView.setText(resultTextView.getText() + ".");
        hasDot = true;
    }
    public void btnResultClick(View view) {
        if (opp != Operator.none) {
            TextView resultTextView = (TextView) findViewById(R.id.resultText);
            double data02 = Double.parseDouble(resultTextView.getText().toString());
            double result = 0;
            switch (opp) {
                case add:
                    result = data01 + data02;
                    break;
                case sub:
                    result = data01 - data02;
                    break;
                case mul:
                    result = data01 * data02;
                    break;
                case div:
                    result = data01 / data02;
                    break;
                default:
//Nothing is done (edge case)
                    break;
            }
            if ( (result - (int)result) != 0) {
                resultTextView.setText(String.valueOf(result));
                hasDot = true; //Result is already a fraction, no "dot" button functionality allowed
            } else {
                resultTextView.setText(String.valueOf((int)result));
                hasDot = false; //Result is not a fraction and therefore we can use the "dot" button
            }
        }
    }
}
