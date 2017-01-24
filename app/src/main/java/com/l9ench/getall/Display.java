package com.l9ench.getall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    Button b4;
    Databasehelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String name=getIntent().getStringExtra("NAME");

        String number=getIntent().getStringExtra("NUMBER");
        databasehelper=new Databasehelper(this,"",null,1);
        final TextView t3=(TextView) findViewById(R.id.textView3);
        TextView t4=(TextView) findViewById(R.id.textView4);
        t3.setText(name);
        t4.setText(number);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b4=(Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resl = t3.getText().toString();
                if (resl.equals("0")) {
                    Toast.makeText(Display.this, "eroor", Toast.LENGTH_SHORT).show();
                } else {
                    databasehelper.delete(resl);
                    Toast.makeText(Display.this, "account deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
