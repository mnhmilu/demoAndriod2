package com.bkash.demoandriodsqllite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivityHttpExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_http_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void openHttpGet(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivityHttpGet.class);
        getApplicationContext().startActivity(intent);
    }

    public void openHttpPost(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivityHttpPost.class);
        getApplicationContext().startActivity(intent);
    }

    public void openHttpGetJsonParse(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivityHttpGetJsonParse.class);
        getApplicationContext().startActivity(intent);
    }

    public void openHttpPostJsonArrayParse(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivityHttpGetJsonArrayParse.class);
        getApplicationContext().startActivity(intent);


    }
}
