package com.example.somkiat.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtResult = findViewById(R.id.txtResult);

        if(isLoggedIn()) {
            Intent intent = getIntent();
            txtResult.setText(intent.getStringExtra("result"));
        } else {
            txtResult.setText("HACK !!");
        }
    }

    private boolean isLoggedIn() {
        SharedPreferencesUser user = new SharedPreferencesUser(this);
        return user.get("user");
    }
}
