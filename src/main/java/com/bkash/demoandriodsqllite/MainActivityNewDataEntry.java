package com.bkash.demoandriodsqllite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MainActivityNewDataEntry extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new_data_entry);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


       // db.execSQL("CREATE TABLE IF NOT EXISTS mytable (name VARTCHAR,age INT(3))");
      //  db.execSQL("DELETE FROM MYTABLE");
       // db.execSQL("INSERT INTO mytable(name,age) VALUES('NAHID',3)");
      //  db.execSQL("INSERT INTO mytable(name,age) VALUES('NAHID2',4)");
       // db.execSQL("INSERT INTO mytable(name,age) VALUES('NAHID3',5)");
      //  db.execSQL("INSERT INTO mytable(name,age) VALUES('NAHID4',6)");



    }

    public void SaveData(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextMyName);
        String editName=editText.getText().toString();
        db =this.openOrCreateDatabase("NahidDb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS mytable (name VARTCHAR,age INT(3))");

        String query ="INSERT INTO mytable(name,age) VALUES("+"'"+editName+"'"+","+3+")";

        db.execSQL(query);

        //Go to Index
        Intent intent = new Intent(getApplicationContext(), MainActivitySQLiteIndex.class);
        getApplicationContext().startActivity(intent);
    }
}
