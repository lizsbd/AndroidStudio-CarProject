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
import com.example.liz.carproject.CarDriver;
import com.example.liz.carproject.Car;



public class HerCar extends AppCompatActivity {
    TextView header, header1, header2, header3, header4, colortext, maketext, horsetext, enginetext ;
    ImageButton close;
    Button set;
    EditText make, color, horse_power, engine_size;
   Car herCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_her_car);
        header = (TextView) findViewById(R.id.header);
        header1 = (TextView) findViewById(R.id.header1);
        header2 = (TextView) findViewById(R.id.header2);
        header3 = (TextView) findViewById(R.id.header3);
        header4 = (TextView) findViewById(R.id.header4);

        maketext = (TextView) findViewById(R.id.maketext);
        colortext = (TextView) findViewById(R.id.colortext);
        horsetext = (TextView) findViewById(R.id.horsetext);
        enginetext = (TextView) findViewById(R.id.enginetext);

        close = (ImageButton) findViewById(R.id.close);
        set = (Button) findViewById(R.id.set);

        make = (EditText) findViewById(R.id.make);
        color = (EditText) findViewById(R.id.color);
        horse_power = (EditText) findViewById(R.id.horse_power);
        engine_size = (EditText) findViewById(R.id.engine_size);


        herCar = new Car("Pink", 300, 2.5, "Volks");

        maketext.setText((CharSequence) herCar.getMake());
        colortext.setText((CharSequence) herCar.getColor());

        horsetext.setText((CharSequence) String.valueOf(herCar.getHorse_power()));
        enginetext.setText((CharSequence) String.valueOf(herCar.getEngine_size()));

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color.getText().toString().trim().length() >0) {
                    herCar.setColor(color.getText().toString());
                    colortext.setText((CharSequence) herCar.getColor());

                }else {
                }
                if(make.getText().toString().trim().length() >0) {
                    herCar.setMake(make.getText().toString());
                    maketext.setText((CharSequence) herCar.getMake());

                }else{

                }
                if(horse_power.getText().toString().trim().length()>0) {
                    herCar.setHorse_power(Double.parseDouble(horse_power.getText().toString()));
                    horsetext.setText((CharSequence) String.valueOf(herCar.getHorse_power()));
                }else {

                }
                if(engine_size.getText().toString().trim().length()>0) {
                    herCar.setEngine_size(Double.parseDouble(engine_size.getText().toString()));
                    enginetext.setText((CharSequence) String.valueOf(herCar.getEngine_size()));
                }else {

                }

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(HerCar.this, CarDriver.class);
                goback.putExtra("hermake",herCar.getMake());
                goback.putExtra("hercolor", herCar.getColor());
                goback.putExtra("herhorse", herCar.getHorse_power());
                goback.putExtra("herengine", herCar.getEngine_size());
                setResult(RESULT_OK, goback);
                finish();
            }
        });
    }
}