package com.tp.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Example1Activity extends AppCompatActivity {

    Intent intent;
    TextView txtMessage, txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        txtMessage = findViewById(R.id.txtMessage);
        txtView1 = findViewById(R.id.txtView1);

        intent = getIntent();
        Bundle b = getIntent().getExtras();

        String value1 = b.getString("text1");
        String Message = b.getString("Message");

        this.txtView1.setText(value1);
        this.txtMessage.setText(Message);
    }

    public void GoBack(View view) {
        Example1Activity.this.finish();
    }
}