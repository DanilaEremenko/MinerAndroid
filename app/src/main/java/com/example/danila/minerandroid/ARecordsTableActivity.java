package com.example.danila.minerandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.List;

public class ARecordsTableActivity extends Activity {

    private DBConnector dbConnector;

    private static final int TEXT_SIZE = 40;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records_table_layout);

        GridLayout gridRecords = findViewById(R.id.records_layout);
        gridRecords.setColumnCount(2);

        dbConnector = new DBConnector(getApplicationContext());
        List<Record> records = dbConnector.getAllRecords(this);


        int i = 1;
        if (records != null)
            for (Record record : records) {
                TextView nameView = new TextView(this);
                TextView timeView = new TextView(this);


                nameView.setText(String.valueOf(i + "\nName\n" + record.getName()));
                nameView.setTextSize(TEXT_SIZE);
                nameView.setTextColor(getResources().getColor(R.color.colorAccent));


                timeView.setText(String.valueOf("Time\n" + record.getTime() + "\n-------------"));
                timeView.setTextSize(TEXT_SIZE * 3 / 4);
                timeView.setTextColor(getResources().getColor(R.color.colorAccent));

                gridRecords.addView(nameView);
                gridRecords.addView(timeView);

                i++;

            }

    }

    @Override
    protected void onDestroy() {
        dbConnector.close();
        super.onDestroy();
    }
}

