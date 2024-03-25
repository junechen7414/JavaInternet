package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static Numbers numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View V){
        numbers = new Numbers();
        Intent myIntent = new Intent(this,activity_second.class);
        this.startActivity(myIntent);
    }
    public  void onStart(){
        super.onStart();
        EditText num1 =(EditText) findViewById(R.id.editTextNum1);
        EditText num2 =(EditText) findViewById(R.id.editTextNum2);
        num1.setText("");
        num2.setText("");
    }
    public class Numbers{
        private int numfirst,numsecond;

        public void setNum1(int n){numfirst = n; }
        public void setNum2(int n){numsecond = n; }

        public int getNum1() {
            return numfirst;
        }

        public int getNum2() {
            return numsecond;
        }
        public Numbers(){
            try {
                EditText num1 =(EditText) findViewById(R.id.editTextNum1);
                EditText num2 =(EditText) findViewById(R.id.editTextNum2);
                setNum1(Integer.parseInt(num1.getText().toString()));
                setNum2(Integer.parseInt(num2.getText().toString()));
            }
            catch (NumberFormatException nfe){
                setNum1(-1);
                setNum2(-1);
            }
        }
    }
}