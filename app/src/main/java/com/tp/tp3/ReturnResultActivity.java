package com.tp.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReturnResultActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private Button btnBack;
    private Button btnCancel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_result);

        // Récupérer les références des éléments d’interface

        this.textViewMessage = (TextView) this.findViewById(R.id.txtViewMessage);
        this.btnBack = (Button) this.findViewById(R.id.btnBackOK);
        this.btnCancel=(Button) findViewById(R.id.btnCancel);

        // Récupérer les données depuis l’intent reçu

        intent = getIntent();
        Bundle b = getIntent().getExtras();
        String Message = b.getString("Message");

        this.textViewMessage.setText(Message);

    }

    public void ResultOk(View view) {
        EditText edtMessageBAck = (EditText) findViewById(R.id.edtReturnTxt);
        String stringToPassBack = edtMessageBAck.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("keyName", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void ResultCancel(View view) {
        Intent intent = new Intent();
        intent.putExtra("keyName", "Action Cancelled");
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}