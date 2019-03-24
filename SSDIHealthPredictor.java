package com.example.tanma.medicare2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SSDIHealthPredictor extends AppCompatActivity {

    Databasehelper mydb;
    int influenza = 0, dehydration = 0, asthama = 0;
    public static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button adds = (Button) findViewById(R.id.button2);
        Button diag = (Button) findViewById(R.id.button);
        final EditText sym = (EditText) findViewById(R.id.editText);
        final ListView lv = (ListView) findViewById(R.id.list);
        final ListView lv2 = (ListView) findViewById(R.id.list2);
        //final TextView tv=(TextView)findViewById(R.id.textView3);
        mydb = new Databasehelper(this);
        boolean g = mydb.insert();
        if (g == true) {
            Toast.makeText(SSDIHealthPredictor.this, "Inserted", Toast.LENGTH_SHORT).show();

        }
        diag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = "influenza";
                if (influenza > dehydration) {
                    if (influenza > asthama) {
                        answer = "influenza";
                    } else
                        answer = "asthma";
                }
                if (dehydration > influenza) {
                    if (dehydration > asthama)
                        answer = "dehydration";
                    else
                        answer = "asthma";
                }
                if (asthama > influenza) {
                    if (asthama > dehydration)
                        answer = "asthma";
                    else
                        answer = "dehydration";
                }
                //Toast.makeText(SSDIHealthPredictor.this,"Your Diagnosis : "+answer,Toast.LENGTH_LONG).show();
                //tv.setText("Your Diagnosis is : "+answer);
                result = answer;
                Intent intent = new Intent(SSDIHealthPredictor.this, ResultActivity.class);
                startActivity(intent);
            }
        });
        final ArrayList symlist = new ArrayList();
        final ArrayList addedsymp = new ArrayList();
        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = sym.getText().toString();
                addedsymp.add(a);
                ArrayAdapter adapter2 = new ArrayAdapter<String>(SSDIHealthPredictor.this, android.R.layout.simple_list_item_1, addedsymp);
                lv2.setAdapter(adapter2);
                sym.setText("");
                Cursor res = mydb.getall();
                while (res.moveToNext()) {


                    if (res.getString(1).toString().equals(a)) {

                        if (res.getString(0).toString().equals("influenza")) {
                            influenza = influenza + 1;
                            if (influenza == 1)
                                symlist.add("influenza");
                        }
                        if (res.getString(0).toString().equals("dehydration")) {
                            dehydration = dehydration + 1;
                            if (dehydration == 1)
                                symlist.add("dehydration");
                        }
                        if (res.getString(0).toString().equals("asthma")) {
                            asthama = asthama + 1;
                            if (asthama == 1)
                                symlist.add("asthma");
                        }
                    }
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(SSDIHealthPredictor.this, android.R.layout.simple_list_item_1, symlist);
                lv.setAdapter(adapter);
            }
        });
    }
}
