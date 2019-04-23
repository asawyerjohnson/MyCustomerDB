package com.example.mycustomerdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create SQLiteOpenHelper Object
        myHelper = new DBHelper(MainActivity.this);

        myHelper.getWritableDatabase();

        // Display Database Name
        Toast.makeText(MainActivity.this, myHelper.getDatabaseName(), Toast.LENGTH_SHORT).show();

        // Create a table
       // myHelper.createTable("customer_tbl");
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Closing database to avoid memory leaks
        myHelper.close();
        Toast.makeText(MainActivity.this, myHelper.getDatabaseName() + " closed!", Toast.LENGTH_SHORT).show();

    }
}
