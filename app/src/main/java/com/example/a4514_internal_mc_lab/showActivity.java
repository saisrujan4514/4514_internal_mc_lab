package com.example.a4514_internal_mc_lab;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class showActivity extends AppCompatActivity {

    TextView name;
    //String names,ids,moms,yoms,cates,prices,quantitys,moes,yoes;
    LinearLayout ll;
    DBHelper dbh=new DBHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //ll=new LinearLayout(getApplicationContext());
        ll=(LinearLayout) findViewById(R.id.lll);
        name=new TextView(this);
    }

    public void show_method(View view) {
        StringBuffer buffer=new StringBuffer();
        Cursor c1=dbh.getData();
        TableLayout tbl=new TableLayout(this);
        String a1="";
        while(c1.moveToNext()){
            a1=c1.getString(0)+" "+c1.getString(1)+" "+c1.getString(2)+" "+c1.getString(3)+" "+c1.getString(4)+" "+c1.getString(5)+" "+c1.getString(6)+" "+c1.getString(7)+" "+c1.getString(8);
            buffer.append(a1+"\n");

        }
        name.setText(buffer.toString());
        ll.addView(name);
    }
}