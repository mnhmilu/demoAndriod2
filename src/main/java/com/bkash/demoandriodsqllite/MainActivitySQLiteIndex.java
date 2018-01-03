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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivitySQLiteIndex extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivityNewDataEntry.class);
                getApplicationContext().startActivity(intent);

                //Sna/ckbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();
            }
        });

        //SQLite exxmaple
        //sq lite exmaple
        SQLiteDatabase db =this.openOrCreateDatabase("NahidDb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS mytable (name VARTCHAR,age INT(3))");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.activity_list_view,R.id.textView,listItems);
        ListView myListView=(ListView) findViewById(R.id.myListView3);
        myListView.setAdapter(adapter);

        Cursor cursor = db.rawQuery("SELECT * FROM mytable",null);
        int nameIndex = cursor.getColumnIndex("name");
        int ageIndex =cursor.getColumnIndex("age");
        try {
            while (cursor.moveToNext()) {
                Log.i("name",cursor.getString(nameIndex));
                Log.i("age",Integer.toString(cursor.getInt(ageIndex)));
                listItems.add(cursor.getString(nameIndex));
            }
        } finally {
            cursor.close();
        }

        // add a handler

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "You clicked " + name, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void goToHome(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        getApplicationContext().startActivity(intent);
    }
}
