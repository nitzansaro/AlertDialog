package com.example.nitza.alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout l;
    AlertDialog.Builder ad;
    CharSequence[] c={"Red","Green","Blue"};
    int [] color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=(LinearLayout) findViewById(R.id.l);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menuc){
        Intent t = new Intent(this, Main2Activity.class);
        startActivity(t);}
        return super.onOptionsItemSelected(item);
    }

    public void b1(View view) {
        ad=new AlertDialog.Builder(this);
        LayoutInflater dialogInterface=this.getLayoutInflater();
        ad.setTitle("Select background color");
        ad.setItems(c, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               if(i==0)
                   l.setBackgroundColor(Color.RED);
                if(i==1)
                    l.setBackgroundColor(Color.GREEN);
                if(i==2)
                    l.setBackgroundColor(Color.BLUE);}
        });
                ad.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                ad.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      l.setBackgroundColor(Color.WHITE);

                    }
                });
    AlertDialog ad1=ad.create();
    ad1.show();}



    public void b2(View view) {
        ad=new AlertDialog.Builder(this);
        color=new int[]{0,0,0};
        this.getMenuInflater();
        ad.setTitle("Select as many colors as you like");
        ad.setMultiChoiceItems(c, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b)
                            if(color[i]==0){
                            color[i]=255; }

                            else {

                            if(color[i]==255){
                            color[i]=0;
                            } }}});
        ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                l.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }});

        ad.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad1=ad.create();
        ad1.show();
    }

    public void b3(View view) {
        l.setBackgroundColor(Color.WHITE);

    }
}

