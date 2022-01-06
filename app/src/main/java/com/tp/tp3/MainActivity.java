package com.tp.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText edtMessage;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMessage = findViewById(R.id.edtMessage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:{
                    Toast.makeText(this, "Action validée", Toast.LENGTH_LONG).show();
                    // get String data from Intent
                    String returnString = data.getStringExtra("keyName");
                    // set text view with string
                    edtMessage.setText(returnString);

                }
                case RESULT_CANCELED:{
                    Toast.makeText(this, "Action annulée", Toast.LENGTH_LONG).show();
                    // get String data from Intent
                    String returnString = data.getStringExtra("keyName");
                    // set text view with string
                    edtMessage.setText(returnString);
                }
            }
        }
    }

    public void GoToAct1(View view) {
        Intent intent = new Intent(MainActivity.this,Example1Activity.class);
        Bundle bundle = new Bundle();

        bundle.putString("text1","This text1 sent from MainActivity at "+new Date());
        bundle.putString("Message", edtMessage.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }

    // Warn : deprecated method
    @SuppressWarnings("deprecation")
    public void GoToRetAct(View view) {
        Intent intent = new Intent(MainActivity.this,ReturnResultActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("text1","This text1 sent from MainActivity at "+new Date());
        bundle.putString("Message", edtMessage.getText().toString());

        intent.putExtras(bundle);

        startActivityForResult(intent,SECOND_ACTIVITY_REQUEST_CODE);
    }

    public void TestImplicit(View view) {
//          composition de num tel
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:0661909090"));
//        startActivity(intent);

//          recherche sur internet
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_WEB_SEARCH);
//        intent.putExtra(SearchManager.QUERY,"Computer");
//        startActivity(intent);

//          Ouverture de galerie photo
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/pictures/*");
//        startActivity(intent);

//          Edition d’un contact par numéro de contact
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_EDIT);
//        intent.setData(Uri.parse("content://contact/people/1"));
//        startActivity(intent);

//          Ouverture d’un éditeur de géolocalisation pour visualiser une position
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:42,12"));
//        startActivity(intent);

//          Affichage d’une position sur google maps directement à partir d’un lien
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("http://maps.google.com/maps?sadd=42.12,10.2&daddr=42.12,10.12"));
//        startActivity(intent);

//          Envoyer un message SMS, tout en envoyant comme data le numéro et aussi le corps du SMS
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("sms:12345"));
//        intent.putExtra("sms_body","Hello");
//        startActivity(intent);

//          Envoyer un email en spécifiant l’@ de destination, l’objet et le corps comme Extra avec l’intent
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:akhannous@uae.ac.ma"));
//        intent.putExtra(Intent.EXTRA_SUBJECT,"Hello");
//        intent.putExtra(Intent.EXTRA_TEXT, "This is a Test");
//        startActivity(intent);

//          Ouverture de fenêtre de paramètres WIFI
//        Intent intent = new Intent();
//        intent.setAction(Settings.ACTION_WIFI_IP_SETTINGS);
//        startActivity(intent);

//        Forcer Android d’afficher toutes les applications susceptibles d’envoyer un message
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:12345"));
        intent.putExtra("sms_body","Hello");
        Intent i = Intent.createChooser(intent,"Choose App");
        startActivity(i);
    }
}