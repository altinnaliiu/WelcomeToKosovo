package com.example.welcometokosova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {


DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText nameData=(EditText)findViewById(R.id.namedata);
        final EditText messageData=(EditText)findViewById(R.id.messagedata);
        final EditText emailData=(EditText)findViewById(R.id.emaildata);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String sendEmailTo = "mensur.hyseni@riinvest.net";
        Button btn=(Button) findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[] { sendEmailTo });
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback nga App");
                i.putExtra(Intent.EXTRA_TEXT,"Name: "+nameData.getText()+"\n Message: "+messageData.getText());
                if(nameData.length() < 3) {
                    nameData.requestFocus();
                    nameData.setError("Emri duhet te jete me i gjate se 3 karaktere");
                }
                if(messageData.length() < 10)
                {
                    messageData.requestFocus();
                    messageData.setError("Mesazhi duhet te jete me i gjate se 10 karaktere");
                }
                if(!emailData.getText().toString().trim().matches(emailPattern)){
                    emailData.requestFocus();
                    emailData.setError("Formati i imelles duhet te jete example@gmail.com");
                }
                else {
                    startActivity(Intent.createChooser(i, null));
                }
            }
        });



    }
}