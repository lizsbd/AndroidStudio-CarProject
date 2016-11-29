package com.example.liz.carproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.liz.carproject.Car;

public class MyCar extends AppCompatActivity {
    TextView header, header1, header2, header3, header4, maketext, colortext, horsetext, enginetext;
    ImageButton close;
    Button set;
    EditText make, color, horse_power, engine_size;
    Car myCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        header = (TextView) findViewById(R.id.header);
        header1 = (TextView) findViewById(R.id.header1);
        header2 = (TextView) findViewById(R.id.header2);
        header3 = (TextView) findViewById(R.id.header3);
        header4 = (TextView) findViewById(R.id.header4);


        close = (ImageButton) findViewById(R.id.close);
        set = (Button) findViewById(R.id.set);

        maketext = (TextView) findViewById(R.id.maketext);
        colortext = (TextView) findViewById(R.id.colortext);
        horsetext = (TextView) findViewById(R.id.horsetext);
        enginetext = (TextView) findViewById(R.id.enginetext);


        make = (EditText) findViewById(R.id.make);
        color = (EditText) findViewById(R.id.color);
        horse_power = (EditText) findViewById(R.id.horse_power);
        engine_size = (EditText) findViewById(R.id.engine_size);


        make.setText(make.getText());
        color.setText(color.getText());
        myCar = new Car();
        myCar.setColor("Blue");
        myCar.setMake("Farrari");
        myCar.setEngine_size(6.5);
        myCar.setHorse_power(650);

        maketext.setText((CharSequence) myCar.getMake());
        colortext.setText((CharSequence) myCar.getColor());

        horsetext.setText((CharSequence) String.valueOf(myCar.getHorse_power()));
        enginetext.setText((CharSequence) String.valueOf(myCar.getEngine_size()));


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color.getText().toString().trim().length() >0) {
                    myCar.setColor(color.getText().toString());
                    colortext.setText((CharSequence) myCar.getColor());
                }else {
                }
                if(make.getText().toString().trim().length() >0) {
                    myCar.setMake(make.getText().toString());
                    maketext.setText((CharSequence) myCar.getMake());
                }else{

                }
                if(horse_power.getText().toString().equals("")) {

                }else {
                    myCar.setHorse_power(Double.parseDouble(horse_power.getText().toString()));
                    horsetext.setText((CharSequence) String.valueOf(myCar.getHorse_power()));
                }
                if(engine_size.getText().toString().equals("")) {

                }else {
                    myCar.setEngine_size(Double.parseDouble(engine_size.getText().toString()));
                    enginetext.setText((CharSequence) String.valueOf(myCar.getEngine_size()));
                }





            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(MyCar.this, CarDriver.class);
                goback.putExtra("mymake",myCar.getMake());
                goback.putExtra("mycolor", myCar.getColor());
                goback.putExtra("myhorse", myCar.getHorse_power());
                goback.putExtra("myengine", myCar.getEngine_size());
                setResult(RESULT_OK, goback);
                finish();
            }
        });

    }
}