package com.bkash.demoandriodsqllite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    // ListView simpleList;
    String countryList[] = {"SQLite Example-1", "CRUD Example", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView, countryList);
        ListView simpleList = (ListView) findViewById(R.id.myListView);
        simpleList.setAdapter(arrayAdapter);


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                              @Override
                                              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                  if (position == 0) {
                                                      Intent intent = new Intent(getApplicationContext(), Main2ActivitySqLite.class);
                                                      getApplicationContext().startActivity(intent);

                                                  }
                                                  if (position == 1) {
                                                      Intent intent = new Intent(getApplicationContext(), MainActivitySQLiteIndex.class);
                                                      getApplicationContext().startActivity(intent);

                                                  }
                                                  else {

                                                      // String name =c(position);

                                                      Toast.makeText(getApplicationContext(), "You clicked " + position, Toast.LENGTH_SHORT).show();

                                                  }
                                              }
                                          }
        );


    }

}
