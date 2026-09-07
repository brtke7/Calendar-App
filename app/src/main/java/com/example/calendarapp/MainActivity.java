package com.example.calendarapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     TextView textViewDate;
     CalendarView dpGetDate;
     Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewDate = findViewById(R.id.textView);
        dpGetDate    = findViewById(R.id.calendarView);
        btnDate      = findViewById(R.id.button);

        btnDate.setOnClickListener(v -> {
            long data = dpGetDate.getDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(data);

            Log.i("getDate", "getDateOk");

            Toast.makeText(this, "kliknięto przycisk", Toast.LENGTH_SHORT).show();

            int day   = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year  = calendar.get(Calendar.YEAR);

            String formattedDate = String.format("%02d.%02d.%dr.", day, month, year);
            textViewDate.setText(formattedDate);
        });

    }
}