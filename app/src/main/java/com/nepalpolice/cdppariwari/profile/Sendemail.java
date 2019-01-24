package com.nepalpolice.cdppariwari.profile;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nepalpolice.cdppariwari.R;


public class Sendemail extends AppCompatActivity {
    Button buttonSend;
    EditText textTo;
    EditText textSubject;
    EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        buttonSend = (Button)findViewById(R.id.buttonSend);
        textTo = (EditText)findViewById(R.id.editTextTo);
        textSubject = (EditText)findViewById(R.id.et_subject);
        textMessage = (EditText)findViewById(R.id.editTextMessage);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"searchbbc1881@gmail.com,nileemasharma012@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "FeedBacks");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}