package com.example.fathu.clickcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    Button btnMain;
    TextView txtJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        txtJudul = (TextView)findViewById(R.id.titlemainmenu);
        txtJudul.setText("BrightYoHeart");

        btnMain = (Button) findViewById(R.id.btnMulai);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),IstighfarClicker.class);
                startActivity(i);
            }
        });

    }
}
