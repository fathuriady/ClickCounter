package com.example.fathu.clickcounter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by fathu on 17-Oct-16.
 */

public class IstighfarClicker extends Activity {
    TextView txtCounter;
    TextView txtJudul;
    Button btnCount;
    Button btnSound;
    ImageView imgLafal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        txtCounter = (TextView)findViewById(R.id.txtCounter);
        txtJudul = (TextView)findViewById(R.id.txtJudul);
        btnCount = (Button)findViewById(R.id.btnCount);
        btnSound = (Button)findViewById(R.id.btnSound);
        imgLafal = (ImageView)findViewById(R.id.imgLafal);

        final Counter counter = new Counter();
        txtCounter.setText(String.valueOf(counter.getCounter()));
        txtJudul.setText("Istighfar");

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.addCounter();
                txtCounter.setText(String.valueOf(counter.getCounter()));


                if(counter.getCounter() == 3){
                    AlertDialog.Builder builder = new AlertDialog.Builder(IstighfarClicker.this);
                    builder.setTitle("Perhatian").setMessage("Bagian ini sudah selesai, lanjut?");

                    //Supaya ga bisa close alertdialog kalo di klik di luar dialog
                    builder.setCancelable(false);

                    //Penambahan button Iya dan Tidak
                    builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(getBaseContext(), SAAClicker.class);
                            startActivity(i);
                            finish();
                        }
                    });
                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            counter.resetCounter();
                            txtCounter.setText(String.valueOf(counter.getCounter()));


                        }
                    });

                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();



                }
            }
        });

    }
}
