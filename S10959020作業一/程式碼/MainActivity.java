package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t = null,result;
    private Spinner sport;
    EditText weight,hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.textView5);
        result = (TextView) findViewById(R.id.textView6);
        sport = (Spinner) findViewById(R.id.sports);
        weight = (EditText) findViewById(R.id.editTextTextPersonName);
        hour = (EditText) findViewById(R.id.editTextTextPersonName2);
        sport.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        switch (parent.getItemAtPosition(pos).toString()){
            case "慢走":
                t.setText("3.2");
                break;
            case "中走":
                t.setText("6.2");
                break;
            case "快走":
                t.setText("9.2");
                break;
            default:
                Toast.makeText(this,"Should not happened", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public  void onNothingSelected(AdapterView<?> arg0){
    }
    public void onClick(View v){
        float w = Float.parseFloat(weight.getText().toString()),h = Float.parseFloat(hour.getText().toString());
        float temp = Float.parseFloat(t.getText().toString());
        if(t.getText()==null){
            Toast.makeText(this,"Choose sport type first", Toast.LENGTH_SHORT).show();
        }
        else{
            result.setText(Float.toString(w*h*temp));
        }
    }
}