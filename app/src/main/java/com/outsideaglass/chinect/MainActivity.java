package com.outsideaglass.chinect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        final Context context = this;
        Button listeningButton = (Button) findViewById(R.id.listeningButton);
        Button writingButton = (Button) findViewById(R.id.writingButton);
        Button readingButton = (Button) findViewById(R.id.readingButton);
        Button speakingButton = (Button) findViewById(R.id.speakingButton);
        Button vocabButton = (Button) findViewById(R.id.vocabButton);
        listeningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ListeningActivity.class);
                startActivity(intent);
            }
        });
        writingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, WritingActivity.class);
                startActivity(intent);
            }
        });
        readingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ReadingActivity.class);
                startActivity(intent);
            }
        });
        speakingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SpeakingActivity.class);
                startActivity(intent);
            }
        });
        vocabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VocabActivity.class);
                startActivity(intent);
            }
        });

    }
}
