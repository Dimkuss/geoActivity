package com.example.geoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Character.isLetter;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){

        Button btn = findViewById(R.id.buttonOK);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = findViewById(R.id.EditTextGeo);
                String uris = text.toString();
                char[] chars = uris.toCharArray();
                if (Character.isLetter(chars[0])) {
                    uri = Uri.parse("geo:?q=" + uris +"");
                } else {
                    uri = Uri.parse("geo:" + uris + "");
                }
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Intent", "NotFound");
                }

            }
        });

    }
}