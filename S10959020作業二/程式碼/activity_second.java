package com.example.ex2;

import static com.example.ex2.MainActivity.numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tosecond();
    }
    public static int GCF(int first,int second){
        while (second !=0){
            int temp =second;
            second = first% second;
            first = temp;
        }
        return first;
    }
    public static int LCM(int num1,int num2){
        if(num1>=num2) return (num1*num2)/GCF(num1,num2);
        else return (num1*num2)/GCF(num2,num1);
    }
    public void tosecond(){
        numbers = (MainActivity.Numbers) numbers;
        TextView show = (TextView) findViewById(R.id.textView);
        int lcm;
        int n1 = numbers.getNum1(),n2 = numbers.getNum2();
        if(n1<0||n2<0){
            show.setText("numbers not right");
        }
        else{
            lcm = LCM(n1,n2);
            show.setText("LCM:"+lcm);
        }
    }
    public void back(View v){
        finish();
    }
}