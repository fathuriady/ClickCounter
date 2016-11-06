package com.example.fathu.clickcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fathu on 16-Oct-16.
 */

public class Clicker extends AppCompatActivity {
    Button btnClick;
    TextView txtCounter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        txtCounter = (TextView) findViewById(R.id.txtCounter);
        btnClick = (Button) findViewById(R.id.btnCount);

        final Counter counter =  new Counter();

        txtCounter.setText(Integer.toString(counter.getCounter()));

        btnClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter.addCounter();
                txtCounter.setText(Integer.toString(counter.getCounter()));

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getBaseContext());

                alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        counter.resetCounter();
                    }
                });


                if(counter.getCounter() == 33){
                    counter.resetCounter();
                    txtCounter.setText(Integer.toString(counter.getCounter()));

                }
            }


        });




    }


}
