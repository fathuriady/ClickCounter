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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fathu on 19-Oct-16.
 */

public class SAAClicker extends Activity {

    TextView txtCounter;
    TextView txtJudul;
    Button btnCount;
    Button btnSound;
    ImageView imgLafal;
    List<JenisDz> jenisdz = new ArrayList<JenisDz>();
    JenisDz jenis;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        txtCounter = (TextView)findViewById(R.id.txtCounter);
        txtJudul = (TextView)findViewById(R.id.txtJudul);
        btnCount = (Button)findViewById(R.id.btnCount);
        btnSound = (Button)findViewById(R.id.btnSound);
        imgLafal = (ImageView)findViewById(R.id.imgLafal);


        jenisdz.add(new JenisDz("Subhanallah",0,0));
        jenisdz.add(new JenisDz("Alhamdulillah",0,0));
        jenisdz.add(new JenisDz("Allahu Akbar",0,0));

        pos = 0;
        jenis = jenisdz.get(pos);



        txtJudul.setText(jenis.getJenisDzikir());
        imgLafal.setImageResource(jenis.getGambarID());



        final Counter counter = new Counter();
        txtCounter.setText(String.valueOf(counter.getCounter()));

        btnCount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter.addCounter();
                txtCounter.setText(String.valueOf(counter.getCounter()));

                if(counter.getCounter()==5){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SAAClicker.this);
                    builder.setTitle("Perhatian").setMessage("Anda telah selesai, lanjut?");

                    builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos==2){
                                Intent i = new Intent(getBaseContext(),MainMenu.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                                finish();
                            }
                            else if(pos<2){
                                pos++;
                                jenis = jenisdz.get(pos);
                                counter.resetCounter();
                                txtCounter.setText(String.valueOf(counter.getCounter()));
                                txtJudul.setText(jenis.getJenisDzikir());

                            }

                        }
                    });

                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos<2){
                                counter.resetCounter();
                                txtCounter.setText(String.valueOf(counter.getCounter()));
                            }
                            if(pos==2) {
                                pos = 0;
                                jenis = jenisdz.get(pos);
                                counter.resetCounter();
                                txtCounter.setText(String.valueOf(counter.getCounter()));
                                txtJudul.setText(String.valueOf(jenis.getJenisDzikir()));
                            }
                        }
                    });
                    builder.setCancelable(false);
                    AlertDialog alertdialog = builder.create();

                    alertdialog.show();

                }
            }

        });

    }
}
