package com.example.liz.carproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class CarDriver extends AppCompatActivity {
    public static final int _REQUEST_CODE_HIS = 1;
    public static final int REQUEST_CODE_HER = 2;
    public static final int REQUEST_CODE_MY = 3;
    TextView his_car, her_car, my_car;
    ImageButton his_button, her_button, my_button;
    Button countnumber, compare ;
    String mymake, mycolor,  hiscolor, hismake,  hermake, hercolor ;
    Double myhorse, myengine,hishorse, hisengine,herhorse, herengine;
    Car  hiscar = new Car("Black",400,3.5,"Honda");
    Car hercar = new Car("Pink", 300, 2.5, "Volks");
    Car mycar = new Car();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_driver);
        his_car = (TextView) findViewById(R.id.his_car);
        her_car = (TextView) findViewById(R.id.her_car);
        my_car = (TextView) findViewById(R.id.my_car);
        his_button = (ImageButton) findViewById(R.id.his_button);
        her_button = (ImageButton) findViewById(R.id.her_button);
        my_button = (ImageButton) findViewById(R.id.my_button);
        countnumber = (Button) findViewById(R.id.countnumber);
        compare = (Button) findViewById(R.id.compare);


        mycar.setColor("Blue");
        mycar.setMake("Farrari");
        mycar.setEngine_size(6.5);
        mycar.setHorse_power(650);

        his_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hispage = new Intent(CarDriver.this, HisCar.class);
                startActivityForResult(hispage,  _REQUEST_CODE_HIS);


            }
        });

        her_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent herpage = new Intent(CarDriver.this, HerCar.class);
                startActivityForResult(herpage,  REQUEST_CODE_HER);


            }
        });

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mypage = new Intent(CarDriver.this, MyCar.class);
                startActivityForResult(mypage,  REQUEST_CODE_MY);


            }
        });







        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CharSequence text1, text2, text3;
                if(mycar.equal(hiscar)){
                    text1= "My car and his car are the same";

                }else {
                    text1 = "My car and his car are different";
                }
                if(mycar.equal(hercar)){
                    text2= "My car and her car are the same";

                }else {
                    text2= "My car and hercar are different";
                }
                if(hercar.equal(hiscar)){
                    text3= "Her car and his car are the same";

                }else {
                    text3 = "Her car and his car are different";
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, text1 , duration);
                toast1.show();
                Toast toast2 = Toast.makeText(context, text2 , duration);
                toast2.show();
                Toast toast3 = Toast.makeText(context, text3 , duration);
                toast3.show();
            }
        });
       countnumber.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Car lastcar = new Car();
               Context context = getApplicationContext();
               int duration = Toast.LENGTH_SHORT;
               CharSequence text = String.valueOf(lastcar.getCount());
               Toast toast = Toast.makeText(context, text , duration);
               toast.show();
           }
       });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent goback){
        if(requestCode==REQUEST_CODE_MY){
            if(resultCode==RESULT_OK){
                mycolor = goback.getExtras().getString("mycolor");
                mymake = goback.getExtras().getString("mymake");
                myhorse = goback.getExtras().getDouble("myhorse");
                myengine = goback.getExtras().getDouble("myengine");
                mycar.setColor(mycolor);
                mycar.setMake(mymake);
                mycar.setEngine_size(myengine);
                mycar.setHorse_power(myhorse);
            }
        }
        if(requestCode==REQUEST_CODE_HER){
            if(resultCode==RESULT_OK) {
                hercolor = goback.getExtras().getString("hercolor");
                hermake = goback.getExtras().getString("hermake");
                herhorse = goback.getExtras().getDouble("herhorse");
                herengine = goback.getExtras().getDouble("herengine");
                hercar.setColor(hercolor);
                hercar.setMake(hermake);
                hercar.setEngine_size(herengine);
                hercar.setHorse_power(herhorse);
            }
            }
        if(requestCode==_REQUEST_CODE_HIS) {
            if (resultCode == RESULT_OK) {

               hiscolor = goback.getExtras().getString("hiscolor");

               hismake = goback.getExtras().getString("hismake");

                hishorse = goback.getExtras().getDouble("hishorse");

                hisengine = goback.getExtras().getDouble("hisengine");
                hiscar.setColor(hiscolor);
                hiscar.setMake(hismake);
                hiscar.setEngine_size(hisengine);
                hiscar.setHorse_power(hishorse);
            }
        }
        super.onActivityResult(requestCode, resultCode, goback);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text1, text2, text3;
                if(mycar.equal(hiscar)){
                    text1= "My car and his car are the same";

                }else {
                    text1 = "My car and his car are different";
                }
                if(mycar.equal(hercar)){
                    text2= "My car and her car are the same";

                }else {
                    text2= "My car and hercar are different";
                }
                if(hercar.equal(hiscar)){
                    text3= "Her car and his car are the same";

                }else {
                    text3 = "Her car and his car are different";
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, text1 , duration);
                toast1.show();
                Toast toast2 = Toast.makeText(context, text2 , duration);
                toast2.show();
                Toast toast3 = Toast.makeText(context, text3 , duration);
                toast3.show();
            }
        });
    }

}
