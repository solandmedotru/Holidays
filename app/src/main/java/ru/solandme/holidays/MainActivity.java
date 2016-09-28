package ru.solandme.holidays;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
        String text = String.valueOf(sharedPreferences.getInt("country", 0));
        textView.setText(text);
    }
}
