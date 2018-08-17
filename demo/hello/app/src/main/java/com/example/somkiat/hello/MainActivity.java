package com.example.somkiat.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit(View view) {
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        // Validation
        if(TextUtils.isEmpty(email)) {
            edtEmail.setError("Invalid email");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            edtPassword.setError("Invalid email");
            return;
        }

        // Pass
        Intent intent = new Intent(this, ResultActivity.class);

        if("somkiat@gmail.com".equals(email) &&
           "12345".equals(password)) {
            intent.putExtra("result", "Success");
        } else {
            intent.putExtra("result", "BAD");
        }

        startActivity(intent);
    }
}
