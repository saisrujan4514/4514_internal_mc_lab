package com.example.a4514_internal_mc_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name,id,mom,yom,cate,price,quantity,moe,yoe;
    String names,ids,moms,yoms,cates,prices,quantitys,moes,yoes;
    DBHelper dbh=new DBHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.name);
        id=(EditText) findViewById(R.id.id1);
        mom=(EditText) findViewById(R.id.mom);
        yom=(EditText) findViewById(R.id.yom);
        cate=(EditText) findViewById(R.id.cate);
        price=(EditText) findViewById(R.id.price);
        quantity=(EditText) findViewById(R.id.quan);
        moe=(EditText) findViewById(R.id.moe);
        yoe=(EditText) findViewById(R.id.yoe);
    }

    public void submit_method(View view) {
        names=name.getText().toString();
        ids=id.getText().toString();
        moms=mom.getText().toString();
        yoms=yom.getText().toString();
        cates=cate.getText().toString();
        prices=price.getText().toString();
        quantitys=quantity.getText().toString();
        moes=moe.getText().toString();
        yoes=yoe.getText().toString();
        Boolean x = dbh.insertmethod(names, ids, moms, yoms, cates, prices, quantitys, moes, yoes);
        if(x)
            Toast.makeText(this, "sucessful insert", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "fail insert", Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view) {
        Intent i1=new Intent(this, com.example.internal_4514.modifyActivity.class);
        startActivity(i1);
    }


    public void show_method(View view) {
        Intent i1=new Intent(this, com.example.internal_4514.showActivity.class);
        startActivity(i1);
    }

    public void search_method(View view) {
        dbh.newmethod();
    }
}