package com.example.a.myapplication;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class matala extends AppCompatActivity {

    Random rnd = new Random();
    String str1,str2,str3;
    EditText et1, et2, et3;
    TextView tv1, tv2;
    double a, b, c;
    double x1, x2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matala);
        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
        et3 = (EditText) findViewById(R.id.e3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    public void random(View view) {
        a = rnd.nextGaussian();
        b = rnd.nextGaussian();
        c = rnd.nextGaussian();
        et1.setText(a + "");
        et2.setText(b + "");
        et3.setText(c + "");

    }
    public void solve(View view) {

        str1 = et1.getText().toString();
        str2 = et2.getText().toString();
        str3 = et3.getText().toString();

        if ((str1.equals("+")) || (str2.equals("+")) || (str3.equals("+")) || (str1.equals("-")) || (str2.equals("-")) || (str3.equals("-"))||(str1.equals(""))||(str2.equals(""))||(str3.equals(""))||(str1.equals("."))||(str2.equals("."))||(str3 .equals("."))) {
            Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
        }
        else{
            a = Double.parseDouble(et1.getText().toString());
            b = Double.parseDouble(et2.getText().toString());
            c = Double.parseDouble(et3.getText().toString());
            Intent si = new Intent(this, activity2.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivityForResult(si, 1);
        }
    }


    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        if (source == 1) {
            if (good == RESULT_OK) {
                if (data_back != null) {
                    tv1.setText("The last x1 was: " + data_back.getStringExtra("x1"));
                    tv2.setText("The last x2 was: " + data_back.getStringExtra("x2"));
                }

            }
        }
    }
}