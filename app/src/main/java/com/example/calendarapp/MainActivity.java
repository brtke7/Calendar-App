package com.example.calendarapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     private TextView   textViewDate;
     private DatePicker dpGetDate;
     private Button     btnDate;

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
        dpGetDate    = findViewById(R.id.datePicker);
        btnDate      = findViewById(R.id.button);

        btnDate.setOnClickListener(v -> {
            textViewDate.setText(getDate());
        });
    }

    public String getDate() {
        Log.i("getDate", "getDateOK");

        Toast.makeText(this, "Kliknięto przycisk!", Toast.LENGTH_LONG).show();

        int day   = dpGetDate.getDayOfMonth();
        int month = dpGetDate.getMonth() + 1;
        int year  = dpGetDate.getYear();

        return String.format("%02d.%02d.%dr", day, month, year);
    }
}