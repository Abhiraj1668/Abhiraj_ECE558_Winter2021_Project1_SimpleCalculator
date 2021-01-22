package ece558.Project1.abhiraj_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAddition(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Double.parseDouble(op1.getText().toString())+Double.parseDouble(op2.getText().toString());
        Result.setText(Double.toString(res));
    }

    public void doSubstract(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Double.parseDouble(op1.getText().toString())-Double.parseDouble(op2.getText().toString());
        Result.setText(Double.toString(res));
    }

    public void doMultiplication(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Double.parseDouble(op1.getText().toString())*Double.parseDouble(op2.getText().toString());
        Result.setText(Double.toString(res));
    }

    public void doDivision(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Double.parseDouble(op1.getText().toString())/Double.parseDouble(op2.getText().toString());
        Result.setText(Double.toString(res));
    }

    public void doPercent(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Double.parseDouble(op1.getText().toString())/100.00;
        Result.setText(Double.toString(res));
    }

    public void doSQRT(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        Double res = Math.sqrt(Double.parseDouble(op1.getText().toString()));
        Result.setText(Double.toString(res));

    }
}