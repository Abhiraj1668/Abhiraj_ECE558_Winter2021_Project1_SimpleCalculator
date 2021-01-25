package ece558.Project1.abhiraj_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        This clsFields object is used to clear the operand input fields if any value is present
        Button ClsFields = findViewById(R.id.btnClear);
//        onclick method for this button object is over written since no onclick method was entered
//        in the layouts onclick field the description for this method is at the bottom of the page
        ClsFields.setOnClickListener(clearListener);
    }

    //These button methods are passed to onclick fields in layouts file
    public void doAddition(View view){
        //Create objects of the two operands edit text and result display text view layouts and
        // gets their ids for further operation
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        //Try and catch used to find any exceptions due to any incomplete operand fields
        try {
            //Gets the input operands as strings and coverts it to double of addition operation
            //Double is used as the user input is decimal and the
            double res = Double.parseDouble(op1.getText().toString())+Double.parseDouble(op2.getText().toString());
            //The addition result is passes as string to setText method of the result object to
            // display the calculated value on screen
            Result.setText(Double.toString(res));
        } catch (Exception e) {
            //If any exception occurs while calculating the result, method to handle all exceptions is called.
            this.handleException(op1,op2,Result);
        }
    }

    //Same process as of addition method is done for the subtraction.
    public void doSubtract(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        try {
            double res = Double.parseDouble(op1.getText().toString())-Double.parseDouble(op2.getText().toString());
            Result.setText(Double.toString(res));
        } catch (Exception e) {
            this.handleException(op1,op2,Result);
        }
    }

    public void doMultiplication(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        try {
            double res = Double.parseDouble(op1.getText().toString())*Double.parseDouble(op2.getText().toString());
            Result.setText(Double.toString(res));
        } catch (Exception e) {
            this.handleException(op1,op2,Result);
        }
    }

    public void doDivision(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        try {
            //This operation has another exception if divide by zero.
            //When user inputs 0 as divisor, no exception is raised but shows result as INFINITE,
            //Therefore, divide by zero exception is manually checked
            //If divisor is not zero then perform division operation
            if (Double.parseDouble(op2.getText().toString()) != 0) {
                double res = Double.parseDouble(op1.getText().toString()) / Double.parseDouble(op2.getText().toString());
                Result.setText(Double.toString(res));
            }
            else {
                //If Divisor is zero then raise toast and clear the fields
                Toast.makeText(this, "ERROR: Number Cannot be Divided by Zero", Toast.LENGTH_SHORT).show();
                op1.getText().clear();
                op2.getText().clear();
                Result.setText("");
                op1.requestFocus();
            }
        } catch (Exception e) {
            this.handleException(op1,op2,Result);
        }
    }

    public void doPercent(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        //This method only uses 1st operand and therefore, exception is only raised if 1st field is nnot entered
        try {
            double res = Double.parseDouble(op1.getText().toString())/100.00;
            Result.setText(Double.toString(res));
        } catch (Exception e) {
            this.handleException(op1,op2,Result);
        }
    }

    public void doSQRT(View view){
        EditText op1 = findViewById(R.id.editText_op1);
        EditText op2 = findViewById(R.id.editText_op2);
        TextView Result = findViewById(R.id.finalResult);
        try {
            double res = Math.sqrt(Double.parseDouble(op1.getText().toString()));
            Result.setText(Double.toString(res));
        } catch (Exception e) {
            this.handleException(op1,op2,Result);
        }
    }

    //This method is used to handle exceptions for all operation methods
    public void handleException(EditText op1, EditText op2, TextView Result){
        //Raises a toast to notify user that wrong values are entered and need to enter new values
        Toast.makeText(this, "ERROR: Enter New operand value(s)", Toast.LENGTH_SHORT).show();
        //Clears both edit text fields and result text view
        op1.getText().clear();
        op2.getText().clear();
        Result.setText("");
        //Sets cursor to the 1st edit text field, which is operand 1
        op1.requestFocus();
        //Opens up number pad
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(op1, InputMethodManager.SHOW_IMPLICIT);
    }

    //This onClick listener overrides the default listener
    //Implemented differently than other button listeners.
    //Passed to setonclicklistener of the required button to override its listener
    protected View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Gets ids of text edit fields and result text view fields
            EditText op1 = findViewById(R.id.editText_op1);
            EditText op2 = findViewById(R.id.editText_op2);
            TextView Result = findViewById(R.id.finalResult);
            //Clears the input fields
            op1.getText().clear();
            op2.getText().clear();
            Result.setText("");
        }
    };

}